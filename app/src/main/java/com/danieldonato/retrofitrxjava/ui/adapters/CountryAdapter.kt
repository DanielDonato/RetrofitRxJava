package com.danieldonato.retrofitrxjava.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danieldonato.retrofitrxjava.api.model.CountryModel
import com.danieldonato.retrofitrxjava.databinding.AdapterCountryBinding

class CountryAdapter(private val countries: List<CountryModel>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder?>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterCountryBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CountryViewHolder,
        position: Int
    ) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    inner class CountryViewHolder(var binding: AdapterCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(country: CountryModel) {
            binding.model = country
        }
    }
}

