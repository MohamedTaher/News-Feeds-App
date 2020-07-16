package com.taher.newsfeeds.data.model

import com.google.gson.Gson

class GetArticlesResponse: BaseResponse() {
    var source: String? = null
    var sortBy: String? = null
    var articles: ArrayList<Article>? = null

    companion object {
        fun instance(jsonString: String): GetArticlesResponse? {
            return try {
                Gson().fromJson(jsonString, GetArticlesResponse::class.java)

            } catch (exception: IllegalStateException) {
                exception.printStackTrace()
                null
            }

        }
    }
}