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
import com.taher.newsfeeds.data.repository.source.remote.network.ApiInterface
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(override val kodein: Kodein): DataSource, KodeinAware {

    private val articleDataApi: ApiInterface by instance()

    override fun getArticles(source: ArticleSource): LiveData<DataWrapper<List<Article>>> {
        val articleData = MutableLiveData<DataWrapper<List<Article>>>()
        articleData.value = DataWrapper.Loading()

        articleDataApi.getArticles(source.value, ApiConfig.API_KEY).enqueue(object: Callback<GetArticlesResponse> {
            override fun onResponse(call: Call<GetArticlesResponse>, response: Response<GetArticlesResponse>) {
                if (response.isSuccessful) {
                    val getArticlesResponse = response.body()
                    if (getArticlesResponse?.status == StatusEnum.OK.value) {
                        articleData.value = DataWrapper.Success(getArticlesResponse.articles ?: arrayListOf())
                    } else {
                        articleData.value = DataWrapper.Error(getArticlesResponse?.message)
                    }
                } else {
                    val errorBodyJsonString = response.errorBody()?.string()
                    val errorBody = errorBodyJsonString?.let { GetArticlesResponse.instance(it) }
                    articleData.value = DataWrapper.Error(errorBody?.message)
                }
            }

            override fun onFailure(call: Call<GetArticlesResponse>, t: Throwable) {
                articleData.value = DataWrapper.Error()
            }

        })

        return articleData
    }
}