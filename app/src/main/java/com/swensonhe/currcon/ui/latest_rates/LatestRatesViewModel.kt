package com.swensonhe.currcon.ui.latest_rates

import android.util.Log
import androidx.lifecycle.ViewModel
import com.swensonhe.currcon.data.Constants
import com.swensonhe.currcon.data.model.ApiResponse
import com.swensonhe.currcon.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LatestRatesViewModel : ViewModel() {

    private val latestRatesService = RetrofitClient.latestRatesService

    fun getLatestRatesFor(currency: String) {
        latestRatesService.getLatestRatesFor(currency, Constants.FIXER_IO_API_KEY)
            .enqueue(object : Callback<ApiResponse> {

                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    Log.d("LatestRatesViewModel", "onResponse: ")
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.d("LatestRatesViewModel", "onFailure: ")
                }
            })
    }
}