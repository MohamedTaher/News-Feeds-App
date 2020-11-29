package com.taher.views.extension

import android.content.Context
import android.widget.Toast
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat

fun Context.makeToast(name: Int) {
    val msg = resources?.getString(name)
    makeToast(msg)
}

fun Context.makeToast(msg: String?) {
    val mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    mToast.show()
}

inline fun <reified T : Activity> Activity.navigate(id: String, sharedView: View? = null,
                                                    transitionName: String? = null) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("id", id)

    var options: ActivityOptionsCompat? = null

    if (sharedView != null && transitionName != null) {
        options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedView, transitionName)
    }

    ActivityCompat.startActivity(this, intent, options?.toBundle())
}

fun Context.openWebPage(url: String): Boolean {
    return try {
        val uri = Uri.parse(url)
        val myIntent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(myIntent)
        true

    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        false
    }
}