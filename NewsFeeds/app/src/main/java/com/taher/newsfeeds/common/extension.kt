package com.taher.newsfeeds.common
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.taher.newsfeeds.R
import java.text.SimpleDateFormat
import java.util.*

//Context
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

//Date
fun Date.toFormattedString(format: String): String {
    val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
    return simpleDateFormat.format(this)
}