package com.taher.newsfeeds.ui.article.details.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.taher.newsfeeds.R
import com.taher.newsfeeds.data.model.Article
import com.taher.views.extension.makeToast

class ArticleDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.app_name)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.article_details_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            R.id.action_search -> makeToast(R.string.action_search)
        }
        return true
    }

    companion object{

        const val ARTICLE_ITEM = "Article Item"

        fun getIntent(context: Context, articleItem: Article): Intent {
            return Intent(context, ArticleDetailsActivity::class.java).apply {
                putExtra(ARTICLE_ITEM, articleItem)
            }
        }
    }
}
