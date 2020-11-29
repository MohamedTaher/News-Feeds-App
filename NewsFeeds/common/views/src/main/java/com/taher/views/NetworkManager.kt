package com.taher.views

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity


object NetworkManager {

    fun isNetworkConnected(context: Context):Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT < 23) {
            val ni = cm.activeNetworkInfo
            if (ni != null) {
                return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
            }
        } else {
            val n: Network? = cm.activeNetwork
            if (n != null) {
                val nc = cm.getNetworkCapabilities(n)
                return (nc?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false) ||
                        (nc?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false)
            }
        }
        return false
    }

}