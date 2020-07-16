package com.taher.newsfeeds.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taher.newsfeeds.data.repository.DataRepository
import com.taher.newsfeeds.ui.article.details.viewmodel.ArticleDetailsViewModel
import com.taher.newsfeeds.ui.article.list.viewmodel.ArticlesListViewModel
import com.taher.newsfeeds.ui.main.viewmodel.MainViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class ViewModelProviderFactory(override val kodein: Kodein): ViewModelProvider.NewInstanceFactory(), KodeinAware {

    private val dataRepository: DataRepository by instance()

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when {

            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                return MainViewModel(dataRepository) as T
            }

            modelClass.isAssignableFrom(ArticlesListViewModel::class.java) -> {
                return ArticlesListViewModel(dataRepository) as T
            }

            modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java) -> {
                return ArticleDetailsViewModel(dataRepository) as T
            }

        }

        throw IllegalArgumentException("Unknown view model class: " + modelClass.name)
    }
}