package com.example.kariscore

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InsertSubject(
    @Expose
    @SerializedName("subject_name")
    val subject_name:String,

    @Expose
    @SerializedName("subject_year")
    val subject_year:Int,

    @Expose
    @SerializedName("subject_term")
    val subject_term:Int,

    @Expose
    @SerializedName("subject_description")
    val subject_description:String,

    @Expose
    @SerializedName("subject_code")
    val subject_code:String
) {}