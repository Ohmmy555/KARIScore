package com.example.kariscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kariscore.databinding.ActivityInsertSubjectBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertSubjectActivity : AppCompatActivity() {

    private lateinit var bindingInsert : ActivityInsertSubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bindingInsert = ActivityInsertSubjectBinding.inflate(layoutInflater)
        setContentView(bindingInsert.root)
    }

    fun insertSubject(v:View) {
        val api : NetwordAPI = Retrofit.Builder()
            .baseUrl("https://kari-api-91by.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetwordAPI::class.java)
        if(bindingInsert.edtName.text.toString().isNotEmpty() &&
            bindingInsert.edtYear.text.toString().isNotEmpty() &&
            bindingInsert.edtTerm.text.toString().isNotEmpty()){
            api.insertSubject(
                bindingInsert.edtName.text.toString(),
                bindingInsert.edtYear.text.toString().toInt(),
                bindingInsert.edtTerm.text.toString().toInt(),
                bindingInsert.edtDetail.text.toString(),
                "code".toString() // โค้ดเข้าห้องเรียน
            ).enqueue(object : Callback<InsertSubject> {
                override fun onResponse(
                    call: Call<InsertSubject>,
                    response:Response<InsertSubject>
                ) {
                    if(response.isSuccessful) {
                        insertOwner()
                    }else {
                        Toast.makeText(applicationContext,
                            "Insert Subject failed ", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<InsertSubject>, t: Throwable) {
                    Toast.makeText(applicationContext,
                        "Error onFailure Subject" + t.message,Toast.LENGTH_LONG).show()
                }
            })
        }else{
            Toast.makeText(applicationContext,
                "Please Enter Info", Toast.LENGTH_LONG).show()
        }

    }

    fun insertOwner() {
        val api : NetwordAPI = Retrofit.Builder()
            .baseUrl("https://kari-api-91by.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetwordAPI::class.java)
        api.insertOwner(
            "1".toString().toInt() , // ดึงไอดีวิชามา
            "7".toString().toInt() , // ดึงไอดีคนสร้างวิชา
            "1".toString().toInt() // อันนี้ไม่ต้องแก้ เพราะเป็นคนสร้างต้องเป็น 1
        ).enqueue(object : Callback<InsertOwner> {
            override fun onResponse(
                call: Call<InsertOwner>,
                response:Response<InsertOwner>
            ) {
                if(response.isSuccessful) {
                    Toast.makeText(applicationContext,
                        "Successfully Inserted", Toast.LENGTH_SHORT).show()
                    // finish()
                }else {
                    Toast.makeText(applicationContext,
                        "Insert Owner failed ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<InsertOwner>, t: Throwable) {
                Toast.makeText(applicationContext,
                    "Error onFailure Owner" + t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}