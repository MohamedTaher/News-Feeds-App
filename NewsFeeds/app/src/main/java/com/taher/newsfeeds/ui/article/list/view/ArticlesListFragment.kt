package com.taher.newsfeeds.ui.article.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taher.newsfeeds.R
import com.taher.newsfeeds.data.repository.DataWrapper
import com.taher.newsfeeds.ui.ViewModelProviderFactory
import com.taher.newsfeeds.utilities.makeToast
import com.taher.newsfeeds.utilities.observe
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.databinding.FragmentArticlesListBinding
import com.taher.newsfeeds.ui.article.details.view.ArticleDetailsActivity
import com.taher.newsfeeds.ui.article.list.viewmodel.ArticlesListViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ArticlesListFragment: Fragment(), KodeinAware, ArticlesRecyclerViewAdapter.Callback {

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

        viewModel.getArticlesData()
    }

    private fun initUi() {
        val adapter = ArticlesRecyclerViewAdapter(this)
        binding.articlesRecyclerView.adapter = adapter

        val spacing = (20 * resources.displayMetrics.density).toInt()
        binding.articlesRecyclerView.addItemDecoration(ArticlesListItemDecoration(spacing))
    }

    private fun subscribeUi() {
        observe(viewModel.articlesListViewModels, ::handleArticlesList)

        binding.swipeArticlesRecyclerView.setOnRefreshListener {
            viewModel.getArticlesData()
        }
    }

    private fun handleArticlesList(articlesData: DataWrapper<List<Article>>) {
        when(articlesData) {
            is DataWrapper.Loading -> showLoadingView(true)
            is DataWrapper.Success -> articlesData.data?.let { bindArticlesListData(it) }
            is DataWrapper.Error -> popupError(articlesData.message)
        }
    }

    private fun showLoadingView(isVisible: Boolean) {
        binding.swipeArticlesRecyclerView.isRefreshing = isVisible
    }

    private fun bindArticlesListData(dataList: List<Article>) {
        showLoadingView(false)

        val adapter = binding.articlesRecyclerView.adapter as? ArticlesRecyclerViewAdapter
        adapter?.setViewModels(dataList)
    }

    private fun popupError(message: String?) {
        showLoadingView(false)

        context?.makeToast(message ?: getString(R.string.connection_error))
    }

    override fun onTapArticle(item: Article) {
        context?.let {
            val intent = ArticleDetailsActivity.getIntent(it, item)
            startActivity(intent)
        }
    }

}