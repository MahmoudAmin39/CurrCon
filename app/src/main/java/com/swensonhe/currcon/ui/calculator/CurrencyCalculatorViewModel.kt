package com.swensonhe.currcon.ui.calculator

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.swensonhe.currcon.data.Constants
import com.swensonhe.currcon.data.model.CurrencyRate

class CurrencyCalculatorViewModel : ViewModel() {

    private var currencyRate: CurrencyRate? = null

    fun setCurrencyRateFromIntent(intent: Intent) {
        this.currencyRate = intent.getParcelableExtra(Constants.INTENT_EXTRA_CURRENCY_RATE)
    }
}