package com.taher.newsfeeds.ui.article.list.viewmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ArticlesListItemViewModel(
    val id: Int,
    val author: String,
    val title: String,
    val urlToImage: String,
    val description: String,
    val publishedAt: Date,
    val url: String
): Parcelable