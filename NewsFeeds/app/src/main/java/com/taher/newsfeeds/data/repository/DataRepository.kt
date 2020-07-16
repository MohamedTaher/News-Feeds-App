package com.taher.newsfeeds.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.data.model.ArticleSource
import com.taher.newsfeeds.data.repository.source.DataSource
import com.taher.newsfeeds.data.repository.source.remote.RemoteDataSource
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class DataRepository(override val kodein: Kodein): DataSource, KodeinAware {

    val cache: CachedData by kodein.instance()

    private val remoteDataSource: RemoteDataSource by kodein.instance()

    fun combineArticles(associatedPressArticlesData: DataWrapper<List<Article>>, theNextWebArticlesData: DataWrapper<List<Article>>): DataWrapper<List<Article>>? {
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

    fun getAllArticles(): LiveData<DataWrapper<List<Article>>> {

        val result = MediatorLiveData<DataWrapper<List<Article>>>()
        result.value = DataWrapper.Loading()

        val associatedPressArticles = getArticles(ArticleSource.AssociatedPress)
        val theNextWebArticles = getArticles(ArticleSource.TheNextWeb)

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

    override fun getArticles(source: ArticleSource): LiveData<DataWrapper<List<Article>>> {
        return remoteDataSource.getArticles(source)
    }
}