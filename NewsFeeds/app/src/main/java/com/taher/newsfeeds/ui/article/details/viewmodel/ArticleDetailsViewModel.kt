package com.taher.newsfeeds.ui.article.details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taher.newsfeeds.data.model.Article
import javax.inject.Inject

class ArticleDetailsViewModel @Inject constructor(): ViewModel() {
    val articleItem: MutableLiveData<Article> = MutableLiveData()
    val openWebsite: MutableLiveData<String> = MutableLiveData()

    fun onOpenWebsiteButtonClick() {
        articleItem.value?.url?.let {
            openWebsite.value = it
        }
    }
}