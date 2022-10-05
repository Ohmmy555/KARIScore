package com.example.kariscore

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface NetwordAPI {
    @GET("allsubject")
    fun retrieveSubject(): Call<List<Subject>>

    @GET("allStudentScore")
    fun retrieveStudentScore(): Call<List<StudentScore>>

    @FormUrlEncoded
    @POST("createsubject")
    fun insertSubject(
        @Field("subject_name") subject_name:String ,
        @Field("subject_description") subject_description:String ,
        @Field("subject_term") subject_term:Int ,
        @Field("subject_year") subject_year:Int ,
        @Field("subject_code") subject_code:String ,
    ): Call<SubjectA>

    @FormUrlEncoded
    @PUT("subject/{subject_id}")
    fun updateStudent(
        @Field("subject_name") subject_name:String ,
        @Field("subject_year") subject_year:Int ,
        @Field("subject_term") subject_term:Int ,
        @Field("subject_description") subject_description:String
    ): Call<SubjectA>

    @DELETE("subject/{subject_id}")
    fun deleteSubject(
        @Path("subject_id") subject_id: String
    ): Call<SubjectA>

    @GET("std/{user_stdid}")
    fun retrieveStudentID(
        @Path("user_stdid") user_stdid: String
    ): Call<Users>

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