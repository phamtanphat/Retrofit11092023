package com.example.retrofit11092023

import com.google.gson.annotations.SerializedName

data class ResponseApi<T> (
    @SerializedName("data")
    val data: T? = null,
    @SerializedName("message")
    val message: String? = null
)
