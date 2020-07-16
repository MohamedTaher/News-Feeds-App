package com.taher.newsfeeds.common

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.taher.newsfeeds.R

@BindingAdapter("isGone")
fun View.bindIsGone(isGone: Boolean) {
    visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter(value = ["imageUrl"], requireAll = false)
fun setImageUrl(imageView: ImageView, url: String?) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.placeholder)
        .into(imageView)
}
