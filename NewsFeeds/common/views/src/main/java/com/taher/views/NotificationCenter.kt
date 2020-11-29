package com.taher.views

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService

class NotificationCenter(private val mContext: Context) {

    enum class NotificationChannelId(val id: String, name: String) {
        default("defaultChannel", "Default Channel"),
        uploadNotificationChannelID("uploadNotificationChannel", "Upload Notification Channel")
    }

    // Customize the notification channel as you wish. This is only for a bare minimum example
    fun createNotificationChannel(channelId: NotificationChannelId = NotificationChannelId.default) {
        if (Build.VERSION.SDK_INT >= 26) {
            val channel = NotificationChannel(
                channelId.id,
                channelId.name,
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

}