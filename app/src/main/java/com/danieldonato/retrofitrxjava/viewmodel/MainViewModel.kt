package com.danieldonato.retrofitrxjava.viewmodel

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.danieldonato.retrofitrxjava.api.BaseCallbackApi
import com.danieldonato.retrofitrxjava.api.model.CountryModel
import com.danieldonato.retrofitrxjava.databinding.ActivityMainBinding
import com.danieldonato.retrofitrxjava.repository.CountriesRepository
import com.danieldonato.retrofitrxjava.ui.adapters.CountryAdapter
import com.danieldonato.retrofitrxjava.ui.base.BaseActivity
import com.danieldonato.retrofitrxjava.ui.navigators.MainNavigator
import retrofit2.Call
import retrofit2.Response

class MainViewModel : BaseViewModel<MainNavigator, ActivityMainBinding>() {

    private val countryRepository = CountriesRepository()
    lateinit var adapter: CountryAdapter
        private set

    init {
    }

    fun getCountries() {
        countryRepository.getCountries(object: BaseCallbackApi<List<CountryModel>>(navigator){
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                super.onResponse(call, response)
                if(!response.isSuccessful) {
                    //TODO mostrar adapter para quando nao tiver items
                    return
                }
                adapter = CountryAdapter(response.body()!!)
                navigator.showCountries()

            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                super.onFailure(call, t)
                //TODO mostrar adapter para quando nao tiver items
            }
        })
    }

}
