package com.danieldonato.retrofitrxjava.api.service

import com.danieldonato.retrofitrxjava.api.model.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface CountriesService {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Call<List<CountryModel>>

}