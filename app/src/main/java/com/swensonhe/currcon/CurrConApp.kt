package com.swensonhe.currcon

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager


class CurrConApp : Application() {

    companion object {

        @JvmStatic
        var instance: CurrConApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun isInternetAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnected
    }
}