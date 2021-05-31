package com.swensonhe.currcon.ui.calculator

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swensonhe.currcon.data.Constants
import com.swensonhe.currcon.data.model.CurrencyRate

class CurrencyCalculatorViewModel : ViewModel() {

    private var currencyRate: CurrencyRate? = null
    private val baseCurrencyData = MutableLiveData(Constants.CURRENCY_BASE)
    private val exchangedCurrencyData = MutableLiveData<String>()
    private val exchangeRateData = MutableLiveData<Float>()

    fun setCurrencyRateFromIntent(intent: Intent) {
        this.currencyRate = intent.getParcelableExtra(Constants.INTENT_EXTRA_CURRENCY_RATE)
        exchangedCurrencyData.value = currencyRate?.exchangedCurrency
        setExchangeRateFor(1.0F)
    }

    fun setExchangeRateFor(value: CharSequence?) {
        if (value == null || value == "") {
            return; }
        try {
            val floatedValue = value.toString().toFloat()
            setExchangeRateFor(floatedValue)
        } catch (e: Exception) {
        }
    }

    private fun setExchangeRateFor(value: Float) {
        exchangeRateData.value = value * currencyRate?.rateValue!!
    }

    fun getExchangeCurrencyData(): LiveData<String> = exchangedCurrencyData

    fun getBaseCurrencyData(): LiveData<String> = baseCurrencyData

    fun getExchangeRateData(): LiveData<Float> = exchangeRateData
}