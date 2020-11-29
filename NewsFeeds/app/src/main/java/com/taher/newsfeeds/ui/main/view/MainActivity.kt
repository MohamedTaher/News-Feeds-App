package com.taher.newsfeeds.ui.main.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import com.taher.newsfeeds.R
import com.taher.newsfeeds.databinding.ActivityMainBinding
import com.taher.newsfeeds.ui.article.list.view.ArticlesListFragment
import com.taher.newsfeeds.ui.main.view.menu.DrawerHeader
import com.taher.newsfeeds.ui.main.view.menu.DrawerMenuItem
import com.taher.newsfeeds.ui.main.viewmodel.MainViewModel
import com.taher.views.base.BaseActivity
import com.taher.views.extension.makeToast
import com.taher.views.extension.replaceFragmentInActivity

class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class.java, R.layout.activity_main),
    DrawerHeader.DrawerCallBack, DrawerMenuItem.DrawerCallBack {

    private var selectedMenuItemPosition: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
