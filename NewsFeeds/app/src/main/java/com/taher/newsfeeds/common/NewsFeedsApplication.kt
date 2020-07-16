package com.taher.newsfeeds.common

import android.app.Application
import com.taher.newsfeeds.data.CachedData
import com.taher.newsfeeds.data.DataRepository
import com.taher.newsfeeds.ui.ViewModelProviderFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class NewsFeedsApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@NewsFeedsApplication))

        bind<CachedData>()                  with singleton { CachedData() }
        bind<DataRepository>()              with singleton { DataRepository(kodein) }

        bind<ViewModelProviderFactory>()    with provider { ViewModelProviderFactory(kodein) }
    }
}