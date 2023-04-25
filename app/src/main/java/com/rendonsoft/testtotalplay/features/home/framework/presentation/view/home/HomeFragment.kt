package com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rendonsoft.testtotalplay.databinding.FragmentHomeBinding
import com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home.adapter.CountryAdapter
import com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home.adapter.ShimmerAdapter
import com.rendonsoft.testtotalplay.features.home.framework.presentation.view.home.uiModels.StateView
import com.rendonsoft.testtotalplay.features.home.framework.presentation.viewModel.CountryViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel by activityViewModel<CountryViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
        initData()
    }

    private fun initView() {
        binding.rvCountries.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.srReload.setOnRefreshListener {
            viewModel.getAllCountries(showPullToRefresh = true)
        }
    }

    private fun initObservers() {
        viewModel.countryState.observe(requireActivity(), stateView())
    }

    private fun initData() {
        viewModel.getAllCountries()
    }

    private fun stateView(): (StateView) -> Unit = { state ->

        binding.viewError.visibility = View.GONE
        binding.viewEmpty.visibility = View.GONE
        binding.srReload.isRefreshing = false

        when (state) {
            is StateView.Shimmer -> {
                val shimmerAdapter = ShimmerAdapter()
                binding.rvCountries.adapter = shimmerAdapter
            }
            is StateView.Empty -> {
                binding.viewEmpty.visibility = View.VISIBLE
                binding.tvEmpty.text = state.message
            }
            is StateView.Error -> {
                binding.viewError.visibility = View.VISIBLE
                binding.tvError.text = state.message
            }
            is StateView.Data -> {
                val adapterData = CountryAdapter(state.list)
                binding.rvCountries.adapter = adapterData
            }
        }
    }
}