package com.taher.newsfeeds.ui.article.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taher.newsfeeds.common.observe
import com.taher.newsfeeds.common.openWebPage
import com.taher.newsfeeds.ui.ViewModelProviderFactory
import com.taher.newsfeeds.databinding.FragmentArticleDetailsBinding
import com.taher.newsfeeds.ui.article.details.viewmodel.ArticleDetailsViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ArticleDetailsFragment: Fragment(), KodeinAware {

    override val kodein by kodein()

    private lateinit var binding: FragmentArticleDetailsBinding
    private lateinit var viewModel: ArticleDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArticleDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val viewModelFactory: ViewModelProviderFactory by kodein.instance()
        viewModel = viewModelFactory.create(ArticleDetailsViewModel::class.java)
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