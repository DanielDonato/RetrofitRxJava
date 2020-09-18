package com.danieldonato.retrofitrxjava.api

import com.danieldonato.retrofitrxjava.api.auth.Authenticated
import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.RequestBody

class ApiRequest : Authenticated() {

    private val json = MediaType.parse("application/json")

    fun <T> getServices(service: Class<T>) : T {
        return retrofit.create(service);
    }

    fun setBody(`object`: JsonObject): RequestBody {
        return RequestBody.create(json, `object`.toString())
    }

    init {
        setupRetrofit()
    }
}