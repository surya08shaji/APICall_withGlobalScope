package com.example.globalscope.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Urls {
    val baseUrl = "https://quotable.io/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}