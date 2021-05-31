package com.swensonhe.currcon.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import com.swensonhe.currcon.CurrConApp
import com.swensonhe.currcon.data.model.ApiResponse
import com.swensonhe.currcon.data.model.CurrencyRate
import com.swensonhe.currcon.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainDataManager {

    private val latestRatesService = RetrofitClient.latestRatesService

    fun getLatestRatesFor(currency: String, callback: (List<CurrencyRate>?, String?) -> Unit) {
        if (CurrConApp.instance?.isInternetAvailable()!!) {
            fetchData(currency, callback)
        } else {
            CurrConApp.instance?.registerReceiver(object : BroadcastReceiver() {
                override fun onReceive(context: Context?, intent: Intent?) {
                    if (CurrConApp.instance?.isInternetAvailable()!!) {
                        fetchData(currency, callback)
                    }
                }
            }, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
            callback(
                null,
                "Please make sure you're connected to the internet.\nThis message will automatically disappear once connected."
            )
        }
    }

    private fun fetchData(currency: String, callback: (List<CurrencyRate>?, String?) -> Unit) {
        latestRatesService.getLatestRatesFor(currency, Constants.FIXER_IO_API_KEY)
            .enqueue(object : Callback<ApiResponse> {

                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.code() == 200) {
                        // Response successful, Parse it
                        val dataMap = response.body()?.rates
                        dataMap.let {
                            val dataList = mutableListOf<CurrencyRate>()
                            it!!.forEach() { mapEntry ->
                                dataList.add(CurrencyRate(mapEntry.key, mapEntry.value))
                            }
                            callback(dataList, null)
                        }
                    } else {
                        callback(
                            null,
                            "Couldn't parse the response. Response code: ${response.code()}"
                        )
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    callback(null, "Something went wrong with the request.\n${t.message}")
                }
            })
    }
}