package com.swensonhe.currcon.data

import com.swensonhe.currcon.data.model.ApiResponse
import com.swensonhe.currcon.data.model.CurrencyRate
import com.swensonhe.currcon.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainDataManager {

    private val latestRatesService = RetrofitClient.latestRatesService

    fun getLatestRatesFor(currency: String, callback: (List<CurrencyRate>?, String?) -> Unit) {
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