package com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rendonsoft.testtotalplay.databinding.CardCountryBinding
import com.rendonsoft.testtotalplay.features.home.domain.CountryItem
import com.rendonsoft.testtotalplay.utils.extensions.loadUrl

class CountryAdapter(
        private val items: List<CountryItem>
) :
        RecyclerView.Adapter<CountryAdapter.PeopleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardCountryBinding.inflate(inflater, parent, false)
        return PeopleHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class PeopleHolder(private val binding: CardCountryBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(
                item: CountryItem,
        ) {
            binding.imFlag.loadUrl(item.flag)
            binding.item = item
        }
    }
}