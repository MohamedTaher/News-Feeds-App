package com.taher.newsfeeds.ui.article.details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taher.newsfeeds.data.DataRepository
import com.taher.newsfeeds.ui.article.list.viewmodel.ArticlesListItemViewModel

class ArticleDetailsViewModel(private val dataRepository: DataRepository): ViewModel() {
    val articleItem: MutableLiveData<ArticlesListItemViewModel> = MutableLiveData()
    val openWebsite: MutableLiveData<String> = MutableLiveData()

    fun onOpenWebsiteButtonClick() {
        articleItem.value?.url?.let {
            openWebsite.value = it
        }
    }
}