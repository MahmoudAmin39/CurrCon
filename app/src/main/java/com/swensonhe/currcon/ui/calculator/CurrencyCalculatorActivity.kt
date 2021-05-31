package com.swensonhe.currcon.ui.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.swensonhe.currcon.R
import com.swensonhe.currcon.ui.latest_rates.LatestRatesViewModel

class CurrencyCalculatorActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(CurrencyCalculatorViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_calculator)

        viewModel.setCurrencyRateFromIntent(intent)
    }
}