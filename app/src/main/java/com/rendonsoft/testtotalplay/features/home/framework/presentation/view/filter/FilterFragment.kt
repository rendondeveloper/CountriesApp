package com.rendonsoft.testtotalplay.features.home.framework.presentation.view.filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rendonsoft.testtotalplay.databinding.FragmentFilterBinding
import com.rendonsoft.testtotalplay.databinding.FragmentHomeBinding
import com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home.adapter.CountryAdapter
import com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home.adapter.ShimmerAdapter
import com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home.uiModels.StateView
import com.rendonsoft.testtotalplay.features.home.framework.presentation.viewModel.CountryViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }
}