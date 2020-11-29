package com.taher.newsfeeds.di.module

import androidx.lifecycle.ViewModel
import com.taher.newsfeeds.di.ViewModelKey
import com.taher.newsfeeds.ui.article.details.viewmodel.ArticleDetailsViewModel
import com.taher.newsfeeds.ui.article.list.viewmodel.ArticlesListViewModel
import com.taher.newsfeeds.ui.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticlesListViewModel::class)
    abstract fun bindArticlesListViewModel(viewModel: ArticlesListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticleDetailsViewModel::class)
    abstract fun bindArticleDetailsViewModel(viewModel: ArticleDetailsViewModel) : ViewModel
}