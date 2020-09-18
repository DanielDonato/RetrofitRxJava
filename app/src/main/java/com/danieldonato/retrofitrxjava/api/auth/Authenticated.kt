package com.danieldonato.retrofitrxjava.api.auth

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class Authenticated {

    private val baseUrl = "https://raw.githubusercontent.com/"

    protected lateinit var retrofit: Retrofit

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

    protected fun setupRetrofit() {
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