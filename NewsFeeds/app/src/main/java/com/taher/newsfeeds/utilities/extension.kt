package com.taher.newsfeeds.utilities
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.taher.newsfeeds.R
import java.text.SimpleDateFormat
import java.util.*
import androidx.lifecycle.Observer

// LifecycleOwner
fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

// Context
fun Context.makeToast(messageId: Int) {
    val message = resources?.getString(messageId) ?: ""
    makeToast(message)
}

fun Context.makeToast(message: String) {
    val mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    mToast!!.show()
}

fun Context.openWebPage(url: String) {
    try {
        val uri = Uri.parse(url)
        val myIntent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(myIntent)

    } catch (e: ActivityNotFoundException) {
        makeToast(R.string.no_application_to_open_web_link)
        e.printStackTrace()
    }
}

// AppCompatActivity
fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, @IdRes frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}

// FragmentManager
fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}

//Date
fun Date.toFormattedString(format: String): String {
    val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
    return simpleDateFormat.format(this)
}