package com.swensonhe.currcon.data.retrofit

import com.swensonhe.currcon.data.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LatestRatesService {

    // http://data.fixer.io/api/latest?access_key=c4235ce0b13e10603861e110637306e0&base=EUR

    @GET("latest")
    fun getLatestRatesFor(@Query("base") currency: String, @Query("access_key") accessKey: String) : Call<ApiResponse>
}