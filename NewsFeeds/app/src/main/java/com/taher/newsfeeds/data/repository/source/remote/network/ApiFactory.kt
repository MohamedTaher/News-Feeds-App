package com.taher.newsfeeds.data.repository.source.remote.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//ApiFactory to create FootBallData Client
object ApiFactory {

    private const val dateFormatString = "yyyy-MM-dd'T'HH:mm:ss.SSSX" //handling utc dates

    //Creating HttpLogging Interceptor to log the contents of request and response bodies.
    private val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    //OkhttpClient for building http request url
    private val footballDataClient = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val gson = GsonBuilder().setDateFormat(dateFormatString).create()

    private fun retrofit() : Retrofit = Retrofit.Builder()
        .client(footballDataClient)
        .baseUrl(ApiConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    val articleDataApi : ApiInterface = retrofit().create(ApiInterface::class.java)
}