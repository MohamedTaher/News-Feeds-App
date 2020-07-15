package com.taher.newsfeeds.data

import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class DataRepository(override val kodein: Kodein): KodeinAware {

    val cache: CachedData by kodein.instance()

}