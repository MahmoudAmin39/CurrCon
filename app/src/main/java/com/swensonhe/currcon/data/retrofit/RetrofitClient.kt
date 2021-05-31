package com.swensonhe.currcon.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://data.fixer.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val latestRatesService: LatestRatesService by lazy {
        retrofit.create(LatestRatesService::class.java)
    }
}