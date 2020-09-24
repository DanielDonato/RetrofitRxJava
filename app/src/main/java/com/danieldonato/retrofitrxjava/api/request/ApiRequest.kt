package com.danieldonato.retrofitrxjava.api.request

import com.danieldonato.retrofitrxjava.api.retrofit.RetrofitConfiguration

class ApiRequest {

    private var retrofit = RetrofitConfiguration().retrofit!! //TODO mudar para de injecao de dependencia

    fun <S> getService(service: Class<S>): S {
        return retrofit.create(service);
    }

}