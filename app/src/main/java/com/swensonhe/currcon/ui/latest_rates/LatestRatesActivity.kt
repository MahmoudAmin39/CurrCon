package com.swensonhe.currcon.ui.latest_rates

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.swensonhe.currcon.R
import kotlinx.android.synthetic.main.activity_latest_rates.*

class LatestRatesActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(LatestRatesViewModel::class.java)
    }

    private val latestRatesAdapter by lazy { LatestRatesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latest_rates)

        // Set the RV
        currenciesWithRatesList.layoutManager = LinearLayoutManager(this)
        currenciesWithRatesList.adapter = latestRatesAdapter

        viewModel.getLatestRatesForBaseCurrency()

        viewModel.getBaseCurrency().observe(this) { textViewBaseCurrency.text = it }
        viewModel.getProgressBarVisibility().observe(this) { progressBar.visibility = it }
        viewModel.getErrorMessageData().observe(this) {
            textViewErrorMessage.visibility = View.VISIBLE
            textViewErrorMessage.text = it
        }
        viewModel.getRatesExchangeData().observe(this) { latestRatesAdapter.addAll(it)}
    }
}