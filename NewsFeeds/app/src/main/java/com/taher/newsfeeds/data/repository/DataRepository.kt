package com.taher.newsfeeds.data.repository

import androidx.lifecycle.LiveData
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.data.model.ArticleSource
import com.taher.newsfeeds.data.repository.source.DataSource
import com.taher.newsfeeds.data.repository.source.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): DataSource {

    override fun getArticles(source: ArticleSource): LiveData<DataWrapper<List<Article>>> {
        return remoteDataSource.getArticles(source)
    }
}