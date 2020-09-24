package com.danieldonato.retrofitrxjava

import android.app.Application
import com.danieldonato.retrofitrxjava.api.retrofit.RetrofitConfiguration

class RetrofitApplication : Application() {

    private lateinit var retrofitConfiguration: RetrofitConfiguration //TODO mudar para modulo de injecao de dependencia

    override fun onCreate() {
        super.onCreate()
        retrofitConfiguration.setupRetrofit()
    }

}