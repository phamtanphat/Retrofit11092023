package com.example.retrofit11092023

import retrofit2.Retrofit

object RetrofitClient {
    private val retrofit: Retrofit by lazy { createRetrofit() }

    fun getInstance(): Retrofit {
        return retrofit
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://json2kt.com/").build()
    }
}