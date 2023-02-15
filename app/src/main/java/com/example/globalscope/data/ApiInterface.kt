package com.example.globalscope.data

import com.example.globalscope.data.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/quotes")
    suspend fun getQuotes() : Response<ResponseModel>
}