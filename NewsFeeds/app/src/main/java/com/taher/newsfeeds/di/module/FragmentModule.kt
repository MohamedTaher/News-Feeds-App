package com.taher.newsfeeds.di.module

import com.taher.newsfeeds.ui.main.view.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}