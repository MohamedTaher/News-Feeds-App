package com.taher.newsfeeds.ui.article.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.data.repository.DataWrapper
import com.taher.newsfeeds.data.repository.DataRepository
import java.util.*
import kotlin.collections.ArrayList

class ArticlesListViewModel(private val dataRepository: DataRepository): ViewModel() {

    private val reloadData: MutableLiveData<Boolean> = MutableLiveData()

    val articlesListViewModels: LiveData<DataWrapper<List<Article>>> = Transformations.switchMap(reloadData) {
        dataRepository.getAllArticles()
    }

    fun getArticlesData() {
        reloadData.value = true
    }

}