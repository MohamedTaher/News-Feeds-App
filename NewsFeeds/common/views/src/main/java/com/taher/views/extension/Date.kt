package com.taher.views.extension

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun Date.toFormattedString(formatString: String, timeZone: TimeZone = TimeZone.getDefault()) : String {
    val format = SimpleDateFormat(formatString, Locale.ENGLISH)
    format.timeZone = timeZone
    return format.format(this)
}

fun Date.toFormattedString(format: String): String {
    val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
    return simpleDateFormat.format(this)
}

fun Date.addTime(time: Date?): Date? {

    if (time == null) return null

    val dateCalender = Calendar.getInstance()
    dateCalender.time = this

    val timeCalender = Calendar.getInstance()
    timeCalender.time = time

    val hour = timeCalender.get(Calendar.HOUR_OF_DAY)
    dateCalender.set(Calendar.HOUR_OF_DAY, hour)

    val minute = timeCalender.get(Calendar.MINUTE)
    dateCalender.set(Calendar.MINUTE, minute)

    val second = timeCalender.get(Calendar.SECOND)
    dateCalender.set(Calendar.SECOND, second)

    return dateCalender.time
}

fun Date.getZeroTimeDate(): Date {
    val calendar = Calendar.getInstance()

    calendar.time = this
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)

    return calendar.time
}

//fun Date.toOffsetDateTime(): OffsetDateTime {
//    val dateString = toFormattedString("yyyy-MM-dd'T'HH:mm:ss")
//    val localDateTime = LocalDateTime.parse(dateString)
//    val offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.UTC)
//
//    return offsetDateTime
//}
//
//fun OffsetDateTime.toDate(): Date {
//    return DateTimeUtils.toDate(toInstant())
//}
//
//@SuppressLint("SimpleDateFormat")
//fun OffsetDateTime.toFormattedString(formatString: String, timeZone: TimeZone = TimeZone.getDefault()): String {
//    val formatter  = DateTimeFormatter.ofPattern(formatString)
//    val localDate = toLocalDate()
//    return localDate.format(formatter)
//}
