package com.swensonhe.currcon.ui.calculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.swensonhe.currcon.R
import kotlinx.android.synthetic.main.activity_currency_calculator.*

class CurrencyCalculatorActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(CurrencyCalculatorViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_calculator)

        viewModel.setCurrencyRateFromIntent(intent)

        viewModel.getBaseCurrencyData().observe(this) { textViewBaseCurrency.text = it }
        viewModel.getExchangeCurrencyData().observe(this) { textViewExchangedCurrency.text = it }
        viewModel.getExchangeRateData().observe(this) { textViewExchangeRate.text = "$it" }

        editTextBaseCurrency.addTextChangedListener(object : CurrConTextWatcher() {

            override fun onTextChanged(value: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setExchangeRateFor(value)
            }
        })
    }
}

abstract class CurrConTextWatcher : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable?) {}
}