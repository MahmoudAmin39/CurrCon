package com.swensonhe.currcon.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyRate(val exchangedCurrency: String, val rateValue: Float) : Parcelable