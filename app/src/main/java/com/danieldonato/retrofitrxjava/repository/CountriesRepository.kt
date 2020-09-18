package com.danieldonato.retrofitrxjava.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.danieldonato.retrofitrxjava.api.ApiRequest
import com.danieldonato.retrofitrxjava.api.BaseCallbackApi
import com.danieldonato.retrofitrxjava.api.model.CountryModel
import com.danieldonato.retrofitrxjava.api.service.CountriesService
import com.danieldonato.retrofitrxjava.ui.base.BaseNavigator
import retrofit2.Call
import retrofit2.Response

class CountriesRepository {

    val services: CountriesService = ApiRequest().getServices(CountriesService::class.java)

    fun getCountries(baseNavigatior: BaseNavigator): LiveData<List<CountryModel>> {
        val liveData = MutableLiveData<List<CountryModel>>()
        services.getCountries()
            .enqueue(object: BaseCallbackApi<List<CountryModel>>(baseNavigatior) {
                override fun onResponse(
                    call: Call<List<CountryModel>>,
                    response: Response<List<CountryModel>>
                ) {
                    super.onResponse(call, response)
                    liveData.value = if(response.isSuccessful) response.body() else emptyList()
                }

                override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                    super.onFailure(call, t)
                    liveData.value = emptyList()
                }
            })
        return liveData
    }


}