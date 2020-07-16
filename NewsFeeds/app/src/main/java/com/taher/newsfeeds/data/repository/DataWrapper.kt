package com.taher.newsfeeds.data.repository

sealed class DataWrapper<out T>(val data: T?, val message: String? = null) {

    class Success<T>(data: T) : DataWrapper<T>(data, null)
    class Loading<T>(data: T? = null) : DataWrapper<T>(data)
    class Error<T>(message: String? = null, data: T? = null) : DataWrapper<T>(null, message)
}