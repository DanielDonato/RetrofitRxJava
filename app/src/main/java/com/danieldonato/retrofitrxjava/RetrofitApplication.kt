package com.danieldonato.retrofitrxjava

import android.app.Application
import com.danieldonato.retrofitrxjava.api.retrofit.RetrofitConfiguration

class RetrofitApplication : Application() {

    private val retrofitConfiguration by lazy { //TODO mudar para modulo de injecao de dependencia
        RetrofitConfiguration()
    }

    override fun onCreate() {
        super.onCreate()
        retrofitConfiguration.setupRetrofit()
    }

}