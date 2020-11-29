package com.taher.newsfeeds.ui.article.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.data.repository.DataWrapper
import com.taher.newsfeeds.usecase.GetAllArticlesUseCase
import javax.inject.Inject

class ArticlesListViewModel @Inject constructor(
    private val getAllArticlesUseCase: GetAllArticlesUseCase
): ViewModel() {

    private val reloadData: MutableLiveData<Boolean> = MutableLiveData()

    val articlesListViewModels: LiveData<DataWrapper<List<Article>>> = Transformations.switchMap(reloadData) {
        getAllArticlesUseCase.invoke()
    }

    fun getArticlesData() {
        reloadData.value = true
    }

}