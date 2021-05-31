package com.swensonhe.currcon.ui.latest_rates

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swensonhe.currcon.data.Constants
import com.swensonhe.currcon.data.MainDataManager
import com.swensonhe.currcon.data.model.CurrencyRate

class LatestRatesViewModel : ViewModel() {

    private val baseCurrency = MutableLiveData(Constants.CURRENCY_BASE)
    private val progressBarVisibility = MutableLiveData<Int>()
    private val ratesExchangeData by lazy { MutableLiveData<List<CurrencyRate>>() }
    private val errorMessageData by lazy { MutableLiveData<String>() }

    fun getLatestRatesForBaseCurrency() {
        if (baseCurrency.value == null) {
            errorMessageData.value =
                "Error occurred. Base currency was not set.\nPlease contact the developer."
            return
        }
        progressBarVisibility.value = View.VISIBLE
        MainDataManager.getLatestRatesFor(baseCurrency.value!!) { rates, errorMessage ->
            progressBarVisibility.value = View.GONE
            if (rates != null && errorMessage == null) {
                // Everything went right
                rates.let { ratesExchangeData.value = it }
            } else if (errorMessage != null && rates == null) {
                // Something went wrong
                errorMessage.let { errorMessageData.value = it }
            }
        }
    }

    fun getProgressBarVisibility(): LiveData<Int> = progressBarVisibility

    fun getRatesExchangeData(): LiveData<List<CurrencyRate>> = ratesExchangeData

    fun getErrorMessageData(): LiveData<String> = errorMessageData

    fun getBaseCurrency(): LiveData<String> = baseCurrency
}