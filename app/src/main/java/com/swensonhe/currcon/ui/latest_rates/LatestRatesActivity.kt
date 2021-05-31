package com.swensonhe.currcon.ui.latest_rates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.swensonhe.currcon.R

class LatestRatesActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(LatestRatesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latest_rates)

        viewModel.getLatestRatesFor("EUR")
    }
}