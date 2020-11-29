package com.taher.newsfeeds.di.module

import com.taher.newsfeeds.ui.article.details.view.ArticleDetailsFragment
import com.taher.newsfeeds.ui.article.list.view.ArticlesListFragment
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindArticlesListFragment(): ArticlesListFragment

    @ContributesAndroidInjector
    abstract fun bindArticleDetailsFragment(): ArticleDetailsFragment

}