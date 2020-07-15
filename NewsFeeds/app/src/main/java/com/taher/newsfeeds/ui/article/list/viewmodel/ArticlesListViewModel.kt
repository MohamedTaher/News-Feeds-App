package com.taher.newsfeeds.ui.article.list.viewmodel

import androidx.lifecycle.ViewModel
import com.taher.newsfeeds.data.DataRepository

class ArticlesListViewModel(private val dataRepository: DataRepository): ViewModel() {

    var articlesListViewModels = ArrayList<ArticlesListItemViewModel>()

    init {
        val vm = ArticlesListItemViewModel(1, "https://img-cdn.tnwcdn.com/image/neural?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2020%2F07%2FUntitled-design-2020-07-15T175816.849.png&signature=78a8851e7e2e020e1b78a57f8525fed2", "This AI spit outs endless new My Little Pony characters", "Thomas Macaulay", "April 12, 2020")
        articlesListViewModels = arrayListOf(vm, vm, vm, vm)
    }

}