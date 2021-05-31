package com.swensonhe.currcon.data.retrofit

import retrofit2.Retrofit

object RetrofitClient {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://http://data.fixer.io/api/")
            .build()
    }

    val latestRatesService by lazy {
        retrofit.create(LatestRatesService::class.java)
    }
}