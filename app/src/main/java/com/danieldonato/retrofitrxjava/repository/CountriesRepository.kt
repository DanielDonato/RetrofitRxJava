package com.danieldonato.retrofitrxjava.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.danieldonato.retrofitrxjava.api.BaseCallbackApi
import com.danieldonato.retrofitrxjava.api.model.CountryModel
import com.danieldonato.retrofitrxjava.api.request.ApiRequest
import com.danieldonato.retrofitrxjava.api.service.CountriesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesRepository {

    private val services: CountriesService = ApiRequest().getService(CountriesService::class.java)

    fun getCountries(callback: Callback<List<CountryModel>>) {
        services.getCountries().enqueue(callback)
    }

}