package com.swensonhe.currcon.ui.latest_rates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swensonhe.currcon.R
import com.swensonhe.currcon.data.model.CurrencyRate

class LatestRatesAdapter : RecyclerView.Adapter<LatestRatesViewHolder>() {

    private val ratesData = mutableListOf<CurrencyRate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestRatesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rate, parent, false)
        return LatestRatesViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: LatestRatesViewHolder, position: Int) {
        holder.bindData(ratesData[position])
    }

    override fun getItemCount(): Int = ratesData.size

    fun addAll(ratesData: List<CurrencyRate>) {
        this.ratesData.clear()
        this.ratesData.addAll(ratesData)
        notifyDataSetChanged()
    }
}