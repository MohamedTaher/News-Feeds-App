package com.taher.newsfeeds.common

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.taher.newsfeeds.R
import java.lang.Exception

@BindingAdapter("isGone")
fun View.bindIsGone(isGone: Boolean) {
    visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
fun setImageUrl(imageView: ImageView, url: String?, placeHolder: Drawable?) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.placeholder)
        .into(imageView, object: Callback{
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
                e?.printStackTrace()
            }

        })
}
