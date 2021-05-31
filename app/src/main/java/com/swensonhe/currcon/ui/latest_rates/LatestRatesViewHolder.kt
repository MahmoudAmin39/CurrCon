package com.swensonhe.currcon.ui.latest_rates

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.swensonhe.currcon.data.Constants
import com.swensonhe.currcon.data.model.CurrencyRate
import com.swensonhe.currcon.ui.calculator.CurrencyCalculatorActivity
import kotlinx.android.synthetic.main.item_rate.view.*

class LatestRatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var currencyRate: CurrencyRate? = null

    init {
        itemView.setOnClickListener {
            val intent = Intent(it.context, CurrencyCalculatorActivity::class.java)
            intent.putExtra(Constants.INTENT_EXTRA_CURRENCY_RATE, currencyRate)
            it.context.startActivity(intent)
        }
    }

    fun bindData(currencyRate: CurrencyRate) {
        this.currencyRate = currencyRate
        itemView.textViewItemExchangedCurrency.text = currencyRate.exchangedCurrency
        itemView.textViewItemRateValue.text = "${currencyRate.rateValue}"
    }
}