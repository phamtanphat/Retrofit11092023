package com.example.retrofit11092023

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val apiService = RetrofitClient.getApiService()
        apiService.getListToDo().enqueue(object : Callback<ResponseApi<List<Todo>>> {
            override fun onResponse(
                call: Call<ResponseApi<List<Todo>>>,
                response: Response<ResponseApi<List<Todo>>>
            ) {
                response.body()?.data?.forEach { Log.d("pphat success", it.toString()) }

            }

            override fun onFailure(call: Call<ResponseApi<List<Todo>>>, t: Throwable) {
                Log.d("pphat error", t.message.toString())
            }
        })
    }
}