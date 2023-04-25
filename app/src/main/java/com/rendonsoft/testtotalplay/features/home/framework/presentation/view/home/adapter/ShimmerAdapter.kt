package com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rendonsoft.testtotalplay.databinding.CardCountryShimmerBinding
import kotlin.random.Random

class ShimmerAdapter(private val listFake: List<Int> = List(4) { Random.nextInt(0, 3) }) : RecyclerView.Adapter<ShimmerAdapter.PeopleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardCountryShimmerBinding.inflate(inflater, parent, false)
        return PeopleHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = listFake.size

    class PeopleHolder(private val binding: CardCountryShimmerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                imFlagShimmer.startShimmer()
                tvNameCountryShimmer.startShimmer()
                tvNameCapitalShimmer.startShimmer()
                tvLabelShimmer.startShimmer()
            }
        }
    }
}