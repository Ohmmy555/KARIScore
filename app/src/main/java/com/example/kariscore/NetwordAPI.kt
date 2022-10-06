package com.example.kariscore

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.time.LocalDate

interface NetwordAPI {
    @GET("allsubject")
    fun retrieveSubject(): Call<List<Subject>>

    @GET("allStudentScore")
    fun retrieveStudentScore(): Call<List<StudentScore>>

    @GET("subjectWork")
    fun retrieveScore(): Call<List<Score>>

    @FormUrlEncoded
    @POST("insertSubject")
    fun insertSubject(
        @Field("subject_name") subject_name:String ,
        @Field("subject_year") subject_year:Int ,
        @Field("subject_term") subject_term:Int ,
        @Field("subject_description") subject_description:String ,
        @Field("subject_code") subject_code:String
    ): Call<InsertSubject>

    @FormUrlEncoded
    @POST("insertOwner")
    fun insertOwner(
        @Field("subject_id") subject_id:Int ,
        @Field("user_id") user_id:Int ,
        @Field("user_type_id") user_type_id:Int
    ): Call<InsertOwner>

    @FormUrlEncoded
    @POST("insertScoreStudent")
    fun insertScoreStudent(
        @Field("score_id") score_id:Int ,
        @Field("user_id") user_id:Int ,
        @Field("score") score:Double
    ): Call<ScoreStudent>

    @FormUrlEncoded
    @POST("createWork")
    fun createWork(
        @Field("score_name") score_name:String,
        @Field("score_date") score_date: LocalDate,
        @Field("full_score") full_score:Int,
        @Field("subject_id") subject_id:Int
    ): Call<CreateWork>

    @FormUrlEncoded
    @PUT("subject/{subject_id}")
    fun updateStudent(
        @Field("subject_name") subject_name:String ,
        @Field("subject_year") subject_year:Int ,
        @Field("subject_term") subject_term:Int ,
        @Field("subject_description") subject_description:String
    ): Call<SubjectWork>

    @DELETE("subject/{subject_id}")
    fun deleteSubject(
        @Path("subject_id") subject_id: String
    ): Call<SubjectWork>

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