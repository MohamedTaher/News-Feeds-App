package com.taher.newsfeeds.ui.article.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.taher.newsfeeds.R
import com.taher.newsfeeds.data.model.Article
import com.taher.newsfeeds.databinding.ArticlesListItemLayoutBinding

class ArticlesRecyclerViewAdapter(private val callback: Callback): RecyclerView.Adapter<ArticlesRecyclerViewAdapter.ViewHolder>() {

    private val articlesViewModels = ArrayList<Article>()

    fun setViewModels(items: List<Article>) {
        articlesViewModels.clear()
        articlesViewModels.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(DataBindingUtil.inflate(inflater, R.layout.articles_list_item_layout, parent, false))
    }

    override fun getItemCount() = articlesViewModels.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(private val binding: ArticlesListItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val itemViewModel = articlesViewModels[position]
            binding.apply {
                viewModel = itemViewModel

                root.setOnClickListener {
                    callback.onTapArticle(itemViewModel)
                }
            }
        }
    }

    interface Callback{
        fun onTapArticle(item: Article)
    }
}