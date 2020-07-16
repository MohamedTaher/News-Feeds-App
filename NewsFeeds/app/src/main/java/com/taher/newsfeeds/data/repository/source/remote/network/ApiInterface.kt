package com.taher.newsfeeds.data.repository.source.remote.network

import com.taher.newsfeeds.data.model.GetArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(ApiConfig.GET_ARTICLES)
    fun getArticles(@Query("source") source: String, @Query("apiKey") apiKey: String): Call<GetArticlesResponse>
}