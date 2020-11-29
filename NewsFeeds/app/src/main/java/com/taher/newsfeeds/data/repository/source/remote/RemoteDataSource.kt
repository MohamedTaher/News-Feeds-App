package com.taher.newsfeeds.data.repository.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.data.model.ArticleSource
import com.taher.newsfeeds.data.model.GetArticlesResponse
import com.taher.newsfeeds.data.model.StatusEnum
import com.taher.newsfeeds.data.repository.DataWrapper
import com.taher.newsfeeds.data.repository.source.DataSource
import com.taher.newsfeeds.data.repository.source.remote.network.ApiConfig
import com.taher.newsfeeds.data.repository.source.remote.network.ArticlesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val articleDataApi: ArticlesService
): DataSource {

    override fun getArticles(source: ArticleSource): LiveData<DataWrapper<List<Article>>> {
        val articleData = MutableLiveData<DataWrapper<List<Article>>>()
        articleData.value = DataWrapper.Loading()

        articleDataApi.getArticles(source.value).enqueue(object: Callback<GetArticlesResponse> {
            override fun onResponse(call: Call<GetArticlesResponse>, response: Response<GetArticlesResponse>) {
                if (response.isSuccessful.not()) {
                    val errorBodyJsonString = response.errorBody()?.string()
                    val errorBody = errorBodyJsonString?.let { GetArticlesResponse.instance(it) }
                    articleData.value = DataWrapper.Error(errorBody?.message)
                    return
                }

                val getArticlesResponse = response.body()

                if (getArticlesResponse?.status != StatusEnum.OK.value) {
                    articleData.value = DataWrapper.Error(getArticlesResponse?.message)
                    return
                }

                articleData.value = DataWrapper.Success(getArticlesResponse.articles ?: arrayListOf())
            }

            override fun onFailure(call: Call<GetArticlesResponse>, t: Throwable) {
                articleData.value = DataWrapper.Error()
            }
        })

        return articleData
    }
}