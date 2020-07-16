package com.taher.newsfeeds.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import com.taher.newsfeeds.R
import com.taher.newsfeeds.ui.ViewModelProviderFactory
import com.taher.newsfeeds.utilities.makeToast
import com.taher.newsfeeds.utilities.replaceFragmentInActivity
import com.taher.newsfeeds.databinding.ActivityMainBinding
import com.taher.newsfeeds.ui.article.list.view.ArticlesListFragment
import com.taher.newsfeeds.ui.main.view.menu.DrawerHeader
import com.taher.newsfeeds.ui.main.view.menu.DrawerMenuItem
import com.taher.newsfeeds.ui.main.viewmodel.MainViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware, DrawerHeader.DrawerCallBack, DrawerMenuItem.DrawerCallBack {

    override val kodein by kodein()

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private var selectedMenuItemPosition: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModelFactory: ViewModelProviderFactory by kodein.instance()
        viewModel = viewModelFactory.create(MainViewModel::class.java)

        initUi()
        subscribeUi()
    }

    private fun initUi() {
        setSupportActionBar(binding.mainToolbar)
        initDrawer()

        replaceFragmentInActivity(ArticlesListFragment(), binding.mainFrameLayout.id)
    }

    private fun initDrawer() {
        val drawerHeader = DrawerHeader(viewModel.menuHeaderViewModel, this)
        binding.drawerPlaceHolderView.addView(drawerHeader)

        viewModel.menuItemsViewModels.forEach {
            val drawerItem = DrawerMenuItem(this, it, this)
            binding.drawerPlaceHolderView.addView(drawerItem)
        }

        val drawerToggle = ActionBarDrawerToggle(this, binding.mainDrawerLayout, binding.mainToolbar, R.string.open_drawer, R.string.close_drawer)
        binding.mainDrawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun subscribeUi() {

    }

    override fun onDrawerHeaderClick() {
        makeToast(R.string.profile)
    }

    override fun onMenuItemClick(position: Int) {

        selectedMenuItemPosition?.let {
            val preMenuSelectedItem = binding.drawerPlaceHolderView.getViewResolverAtPosition(it) as? DrawerMenuItem
            preMenuSelectedItem?.selectedLayout?.visibility = View.INVISIBLE
        }

        val currentMenuSelectedItem = binding.drawerPlaceHolderView.getViewResolverAtPosition(position) as? DrawerMenuItem
        currentMenuSelectedItem?.selectedLayout?.visibility = View.VISIBLE

        selectedMenuItemPosition = position

        val menuItem = viewModel.menuItemsViewModels.first { it.type.position == position }
        makeToast(menuItem.name)

        //binding.mainDrawerLayout.closeDrawers()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_search) {
            makeToast(R.string.action_search)
        }

        return super.onOptionsItemSelected(item)

    }
}
