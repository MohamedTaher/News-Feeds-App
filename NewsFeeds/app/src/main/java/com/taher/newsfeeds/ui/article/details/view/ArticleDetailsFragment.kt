package com.taher.newsfeeds.ui.article.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taher.views.extension.observe
import com.taher.views.extension.openWebPage
import com.taher.newsfeeds.databinding.FragmentArticleDetailsBinding
import com.taher.newsfeeds.ui.article.details.viewmodel.ArticleDetailsViewModel
import com.taher.views.base.BaseFragment

class ArticleDetailsFragment: BaseFragment<ArticleDetailsViewModel>(ArticleDetailsViewModel::class.java) {

    private lateinit var binding: FragmentArticleDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArticleDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        activity?.intent?.apply {
            viewModel.articleItem.value = getParcelableExtra(ArticleDetailsActivity.ARTICLE_ITEM)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        subscribeUi()
    }

    private fun initUi() {

    }

    private fun subscribeUi() {
        observe(viewModel.openWebsite, ::openWebsite)
    }

    private fun openWebsite(url: String) {
        context?.openWebPage(url)
    }

}