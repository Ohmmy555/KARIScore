package com.example.kariscore

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface NetwordAPI {
    @GET("allsubject")
    fun retrieveSubject(): Call<List<Subject>>

    @FormUrlEncoded
    @POST("createsubject")
    fun insertSubject(
        @Field("subject_name") subject_name:String ,
        @Field("subject_description") subject_description:String ,
        @Field("subject_term") subject_term:Int ,
        @Field("subject_year") subject_year:Int ,
        @Field("subject_code") subject_code:String ,
    ): Call<SubjectA>

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