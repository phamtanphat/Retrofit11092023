package com.example.retrofit11092023

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val retrofit: Retrofit by lazy { createRetrofit() }
    private val apiService = retrofit.create(ApiService::class.java)

    fun getRetrofit() = retrofit

    fun getApiService() = apiService

    private fun createRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder().create()

        return Retrofit.Builder()
            .baseUrl("http://androidapp.infinityfreeapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }
}