package com.taher.newsfeeds.common

import android.app.Application
import com.taher.newsfeeds.data.repository.CachedData
import com.taher.newsfeeds.data.repository.DataRepository
import com.taher.newsfeeds.data.repository.source.remote.RemoteDataSource
import com.taher.newsfeeds.data.repository.source.remote.network.ApiFactory
import com.taher.newsfeeds.data.repository.source.remote.network.ApiInterface
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

        bind<ApiInterface>()        with singleton { ApiFactory.articleDataApi }
        bind<CachedData>()          with singleton { CachedData() }
        bind<DataRepository>()      with singleton {DataRepository(kodein)}

        bind<ViewModelProviderFactory>()    with provider { ViewModelProviderFactory(kodein) }
        bind<RemoteDataSource>()            with provider { RemoteDataSource(kodein) }
    }
}