package com.taher.newsfeeds.ui.main.view.menu

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.taher.newsfeeds.R
import com.taher.newsfeeds.ui.main.viewmodel.DrawerMenuItemViewModel

@Layout(R.layout.drawer_item)
class DrawerMenuItem(
    private val context: Context,
    private var viewModel: DrawerMenuItemViewModel,
    private var mCallBack: DrawerCallBack
) {

    @View(R.id.main_drawer_item_layout)
    lateinit var mainLayout: LinearLayout

    @View(R.id.drawer_item_title_text_view)
    lateinit var titleTextView: TextView

    @View(R.id.drawer_item_image_view)
    lateinit var iconImageView: ImageView

    @View(R.id.drawer_selected_layout)
    lateinit var selectedLayout: ImageView

    @Resolve
    fun onResolved() {
        titleTextView.text = context.getString(viewModel.name)

        val drawable = context.getDrawable(viewModel.imageDrawableId)
        iconImageView.setImageDrawable(drawable)
    }

    @Click(R.id.main_drawer_item_layout)
    fun onMenuItemClick(){
        mCallBack.onMenuItemClick(viewModel.type.position)
    }

    interface DrawerCallBack {
        fun onMenuItemClick(position: Int)
    }
}