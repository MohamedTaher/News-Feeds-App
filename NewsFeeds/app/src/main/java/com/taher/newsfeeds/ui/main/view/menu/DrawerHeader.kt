package com.taher.newsfeeds.ui.main.view.menu

import android.widget.TextView
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.taher.newsfeeds.R
import com.taher.newsfeeds.ui.main.viewmodel.DrawerHeaderViewModel

@Layout(R.layout.drawer_header)
class DrawerHeader(
    private var viewModel: DrawerHeaderViewModel,
    private var mCallBack: DrawerCallBack? = null
) {

    @View(R.id.name_text_view)
    lateinit var nameTextView: TextView

    @Resolve
    fun onResolved() {
        nameTextView.text = viewModel.name
    }

    @Click(R.id.drawer_header_layout)
    fun onMenuItemClick(){
        mCallBack?.onDrawerHeaderClick()
    }

    interface DrawerCallBack {
        fun onDrawerHeaderClick()
    }
}