package com.taher.newsfeeds

import com.taher.newsfeeds.di.AppComponent
import com.taher.newsfeeds.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class NewsFeedsApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        //Build app component
        val appComponent: AppComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        //inject application instance
        appComponent.inject(this)
        return appComponent
    }
}