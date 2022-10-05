package com.example.kariscore

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InsertOwner(
    @Expose
    @SerializedName("subject_id")
    val subject_id:Int,

    @Expose
    @SerializedName("user_id")
    val user_id:Int,

    @Expose
    @SerializedName("user_type_id")
    val user_type_id:Int
) {}