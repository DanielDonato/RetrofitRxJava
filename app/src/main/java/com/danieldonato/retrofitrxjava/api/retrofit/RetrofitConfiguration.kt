package com.danieldonato.retrofitrxjava.api.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConfiguration {
    private val baseUrl = "https://raw.githubusercontent.com/"

    var retrofit: Retrofit? = null
        private set

    private val client =
        OkHttpClient.Builder().addInterceptor { chain ->
            var newRequest = chain.request()
//            if (apiToken != null && apiToken!!.isNotEmpty()) {
//                newRequest = chain.request().newBuilder()
//                    .addHeader(
//                        "Authorization",
//                        apiToken
//                    )
//                    .build()
//            }
            chain.proceed(newRequest)
        }.connectTimeout(
            CONNECTION_TIMEOUT.toLong(),
            TimeUnit.MINUTES
        ).readTimeout(1, TimeUnit.MINUTES).build()

    fun setupRetrofit() {
        if(retrofit == null) {
            //TODO verificar quantas vezes entra aqui
            return
        }
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        private const val CONNECTION_TIMEOUT = 20 * 1000
    }
}