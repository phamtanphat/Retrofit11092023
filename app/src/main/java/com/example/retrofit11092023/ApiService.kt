package com.example.retrofit11092023

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("Api11092024/list_todo.php")
    fun getListToDo(): Call<ResponseApi<List<Todo>>>
}