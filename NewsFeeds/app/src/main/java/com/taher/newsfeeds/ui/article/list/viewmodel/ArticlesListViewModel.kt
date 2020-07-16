package com.taher.newsfeeds.ui.article.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taher.newsfeeds.data.DataWrapper
import com.taher.newsfeeds.data.DataRepository
import java.util.*
import kotlin.collections.ArrayList

class ArticlesListViewModel(private val dataRepository: DataRepository): ViewModel() {

    val articlesListViewModels: MutableLiveData<DataWrapper<ArrayList<ArticlesListItemViewModel>>> = MutableLiveData()

    fun getArticlesData() {
        articlesListViewModels.value = DataWrapper.Loading()

        val vm = ArticlesListItemViewModel(
            1,
            "Thomas Macaulay",
            "This AI spit outs endless new My Little Pony characters",
            "https://img-cdn.tnwcdn.com/image/neural?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2020%2F07%2FUntitled-design-2020-07-15T175816.849.png&signature=78a8851e7e2e020e1b78a57f8525fed2",
            "My Little Pony has a curiously broad set of fans, from little girls to adult male “bronies” and, err, Nazis. But since the cartoon series Friendship Is Magic ended in 2019, there’s been no new adventures of the Mane Six gang for fans to enjoy. Luckily for them, an AI system called This Pony Does Not Exist is helping fill",
            Date(),
            "https://thenextweb.com/neural/2020/07/15/this-ai-spit-outs-endless-new-my-little-pony-characters/"
        )
        val viewModels = arrayListOf(vm, vm, vm, vm)

        articlesListViewModels.value = DataWrapper.Success(viewModels)
    }

}