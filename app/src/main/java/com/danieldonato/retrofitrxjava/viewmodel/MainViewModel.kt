package com.danieldonato.retrofitrxjava.viewmodel

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.danieldonato.retrofitrxjava.databinding.ActivityMainBinding
import com.danieldonato.retrofitrxjava.repository.CountriesRepository
import com.danieldonato.retrofitrxjava.ui.adapters.CountryAdapter
import com.danieldonato.retrofitrxjava.ui.base.BaseActivity
import com.danieldonato.retrofitrxjava.ui.navigators.MainNavigator

class MainViewModel : BaseViewModel<MainNavigator, ActivityMainBinding>() {

    private val countryRepository = CountriesRepository()
    lateinit var adapter: CountryAdapter
        private set

    init {
        binding.viewModel = this
        getCountries()
    }

    private fun getCountries() {
        countryRepository.getCountries(navigator)
            .observe(binding.lifecycleOwner!!, Observer {
                adapter = CountryAdapter(it)
                navigator.showCountries()
            })
    }

}
