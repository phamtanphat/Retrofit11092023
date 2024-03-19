package com.example.retrofit11092023

import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("id_status")
    var idStatus: String? = null
)