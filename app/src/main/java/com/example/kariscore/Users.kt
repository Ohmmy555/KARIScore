package com.example.kariscore

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Users (
    @Expose
    @SerializedName("user_stdid") val user_stdid: String,
    @Expose
    @SerializedName("user_name") val user_name: String){}
