package com.taher.newsfeeds.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.taher.newsfeeds.R
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {

    enum class MenuItemType(val position: Int) {
        Explore     (1),
        LiveChat    (2),
        Gallery     (3),
        WishList    (4),
        EMagazine   (5),
    }

    private val name = "Tony Roshdy" //TODO read it from cached data

    var menuHeaderViewModel = DrawerHeaderViewModel(name)
    var menuItemsViewModels = arrayListOf(
        DrawerMenuItemViewModel(R.drawable.explore,             R.string.explore,           MenuItemType.Explore),
        DrawerMenuItemViewModel(R.drawable.live,                R.string.live_chat,         MenuItemType.LiveChat),
        DrawerMenuItemViewModel(R.drawable.gallery,             R.string.gallery,           MenuItemType.Gallery),
        DrawerMenuItemViewModel(R.drawable.wishlist,            R.string.wish_list,         MenuItemType.WishList),
        DrawerMenuItemViewModel(R.drawable.e_magazine,          R.string.e_magazine,        MenuItemType.EMagazine)
    )

}