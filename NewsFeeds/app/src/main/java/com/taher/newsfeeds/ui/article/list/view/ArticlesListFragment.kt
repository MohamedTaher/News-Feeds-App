package com.taher.newsfeeds.ui.article.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taher.newsfeeds.common.ViewModelProviderFactory
import com.taher.newsfeeds.databinding.FragmentArticlesListBinding
import com.taher.newsfeeds.ui.article.list.viewmodel.ArticlesListViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ArticlesListFragment: Fragment(), KodeinAware {

    override val kodein by kodein()

    private lateinit var binding: FragmentArticlesListBinding
    private lateinit var viewModel: ArticlesListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArticlesListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val viewModelFactory: ViewModelProviderFactory by kodein.instance()
        viewModel = viewModelFactory.create(ArticlesListViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        subscribeUi()
    }

    private fun initUi() {
        val adapter = ArticlesRecyclerViewAdapter()
        binding.articlesRecyclerView.adapter = adapter
        binding.articlesRecyclerView.addItemDecoration(ArticlesListItemDecoration(30))

        adapter.setViewModels(viewModel.articlesListViewModels)
    }

    private fun subscribeUi() {

    }
}