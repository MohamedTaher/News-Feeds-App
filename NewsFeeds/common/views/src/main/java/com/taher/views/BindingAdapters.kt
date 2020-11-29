package com.taher.views

import android.view.View
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("isGone")
fun View.bindIsGone(isGone: Boolean) {
    visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter(value = ["placeholder", "imageUrl"], requireAll = false)
fun setImageUrl(imageView: ImageView, @IdRes placeholder: Int?, url: String?) {

    if (url != null && url.isEmpty()) {
        if (placeholder != null) {
            imageView.setImageResource(placeholder!!)
        } else {
            imageView.setImageResource(0)
        }
        return
    }

    val picasso = Picasso.get().load(url)

    if (placeholder != null) {
        picasso.placeholder(placeholder!!)
        picasso.error(placeholder!!)
    }

    picasso.into(imageView)
}
