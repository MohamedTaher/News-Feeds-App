package com.taher.newsfeeds.utilities

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
    if (url != null && url.isEmpty()) {
        imageView.setImageResource(R.drawable.placeholder)
        return
    }

    Picasso.get()
        .load(url)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder)
        .into(imageView)
}
