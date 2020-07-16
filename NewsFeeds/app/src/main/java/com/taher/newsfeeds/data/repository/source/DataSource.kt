package com.taher.newsfeeds.data.repository.source

import androidx.lifecycle.LiveData
import com.taher.newsfeeds.data.repository.DataWrapper
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.data.model.ArticleSource

interface DataSource {
    fun getArticles(source: ArticleSource): LiveData<DataWrapper<List<Article>>>
}