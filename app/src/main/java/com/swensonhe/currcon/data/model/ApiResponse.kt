package com.swensonhe.currcon.data.model

import com.google.gson.annotations.SerializedName

/*
* "success":true,
  "timestamp":1622468584,
  "base":"EUR",
  "date":"2021-05-31",
  "rates":{
  * "", ""}
* */
data class ApiResponse(@SerializedName("success") val success: Boolean?,
                       @SerializedName("timestamp") val timeStamp: Int?,
                       @SerializedName("base") val base: String?,
                       @SerializedName("date") val date: String?,
                       @SerializedName("rates") val rates: Map<String, Float>?)