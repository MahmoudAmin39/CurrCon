package com.swensonhe.currcon.ui.latest_rates

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.swensonhe.currcon.data.model.CurrencyRate
import kotlinx.android.synthetic.main.item_rate.view.*

class LatestRatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(currencyRate: CurrencyRate) {
        itemView.textViewItemExchangedCurrency.text = currencyRate.exchangedCurrency
        itemView.textViewItemRateValue.text = "${currencyRate.rateValue}"
    }
}