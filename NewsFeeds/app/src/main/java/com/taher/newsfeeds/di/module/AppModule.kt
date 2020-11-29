package com.taher.newsfeeds.di.module

import androidx.lifecycle.ViewModelProvider
import com.taher.newsfeeds.ui.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

//    @Binds
//    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory) : ViewModelProvider.Factory
}