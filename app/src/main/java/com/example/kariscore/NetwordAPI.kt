package com.example.kariscore

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NetwordAPI {
    @GET("allsubject")
    fun retrieveSubject(): Call<List<Subject>>

    companion object {
        fun create(): NetwordAPI {
            val stdClient: NetwordAPI = Retrofit.Builder()
                .baseUrl("https://kari-api-91by.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetwordAPI::class.java)
            return stdClient
        }
    }
}