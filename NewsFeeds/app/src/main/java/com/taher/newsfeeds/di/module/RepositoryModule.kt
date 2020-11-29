package com.taher.newsfeeds.di.module

import com.taher.newsfeeds.data.repository.DataRepository
import com.taher.newsfeeds.data.repository.source.DataSource
import com.taher.newsfeeds.data.repository.source.remote.RemoteDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsRemoteDataSource(repository: RemoteDataSource): DataSource

    @Binds
    abstract fun bindsDataRepository(repository: DataRepository): DataSource
}