package com.taher.newsfeeds.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.data.model.ArticleSource
import com.taher.newsfeeds.data.repository.DataRepository
import com.taher.newsfeeds.data.repository.DataWrapper
import javax.inject.Inject
import javax.inject.Singleton

class GetAllArticlesUseCase @Inject constructor(
    private val repository: DataRepository
): () -> LiveData<DataWrapper<List<Article>>> {

    private fun combineArticles(associatedPressArticlesData: DataWrapper<List<Article>>, theNextWebArticlesData: DataWrapper<List<Article>>): DataWrapper<List<Article>>? {
        if (associatedPressArticlesData is DataWrapper.Loading || theNextWebArticlesData is DataWrapper.Loading) {
            return null
        }

        val articles = ArrayList<Article>()

        when (associatedPressArticlesData) {
            is DataWrapper.Success -> articles.addAll(associatedPressArticlesData.data ?: arrayListOf())
            is DataWrapper.Error -> return DataWrapper.Error(associatedPressArticlesData.message)
        }

        when (theNextWebArticlesData) {
            is DataWrapper.Success -> articles.addAll(theNextWebArticlesData.data ?: arrayListOf())
            is DataWrapper.Error -> return DataWrapper.Error(theNextWebArticlesData.message)
        }

        articles.sortByDescending { it.publishedAt }

        return DataWrapper.Success(articles)
    }

    override fun invoke(): LiveData<DataWrapper<List<Article>>> {

        val result = MediatorLiveData<DataWrapper<List<Article>>>()
        result.value = DataWrapper.Loading()

        val associatedPressArticles = repository.getArticles(ArticleSource.AssociatedPress)
        val theNextWebArticles = repository.getArticles(ArticleSource.TheNextWeb)

        result.addSource(associatedPressArticles) {
            combineArticles(
                associatedPressArticlesData = associatedPressArticles.value ?: DataWrapper.Error(),
                theNextWebArticlesData = theNextWebArticles.value?: DataWrapper.Error()
            )?.let { result.value = it }
        }

        result.addSource(theNextWebArticles) {
            combineArticles(
                associatedPressArticlesData = associatedPressArticles.value ?: DataWrapper.Error(),
                theNextWebArticlesData = theNextWebArticles.value?: DataWrapper.Error()
            )?.let { result.value = it }
        }

        return result
    }

}