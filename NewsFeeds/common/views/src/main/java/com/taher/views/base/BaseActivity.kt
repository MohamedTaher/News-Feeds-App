package com.taher.views.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel>(
    private val viewModelClass: Class<VM>,
    @LayoutRes val layoutRes: Int

): DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create data binding view
        binding = DataBindingUtil.setContentView(this, layoutRes)
        //provide view model
        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass)
    }
}