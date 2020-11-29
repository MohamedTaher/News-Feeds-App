package com.taher.newsfeeds.di


import android.app.Application
import com.taher.newsfeeds.NewsFeedsApplication
import com.taher.newsfeeds.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<NewsFeedsApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: NewsFeedsApplication?)
}