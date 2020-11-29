package com.taher.newsfeeds.di.module

import com.taher.network.createNetworkClient
import com.taher.newsfeeds.BuildConfig
import com.taher.newsfeeds.data.repository.source.remote.network.ApiConfig
import com.taher.newsfeeds.data.repository.source.remote.network.ArticlesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule {

    @Provides
    internal fun providesRetrofit(): Retrofit =
        createNetworkClient(
            ApiConfig.BASE_URL,
            ApiConfig.DATE_FORMAT, BuildConfig.DEBUG)
            .build()

    @Provides
    internal fun provideArticlesService(retrofit: Retrofit): ArticlesService =
        retrofit.create(ArticlesService::class.java)
}