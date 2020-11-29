package com.taher.views.extension

import android.annotation.SuppressLint
import android.text.Editable
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

@SuppressLint("SimpleDateFormat")
fun String.toDate(format: String): Date? {
    return try {
        SimpleDateFormat(format).parse(this)
    } catch (e: Exception) {
        null
    }

}

fun String.toFormattedDateString(apiFormat: String, viewFormat: String): String? {
    val date: Date = toDate(apiFormat) ?: return null
    return date.toFormattedString(viewFormat)
}

fun Double.toString(places:Int): String {
    val number = String.format("%.${places}f", this).toDouble()
    return number.toString()
}