package com.taher.views.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment <VM : ViewModel>(
    private val viewModelClass: Class<VM>
): DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //provide view model
        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass)
    }
}