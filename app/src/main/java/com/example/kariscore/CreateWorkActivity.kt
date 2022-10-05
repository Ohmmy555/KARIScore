package com.example.kariscore

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.kariscore.databinding.ActivityCreateWorkBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CreateWorkActivity : AppCompatActivity() {

    private lateinit var bindingCreate : ActivityCreateWorkBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bindingCreate = ActivityCreateWorkBinding.inflate(layoutInflater)
        setContentView(bindingCreate.root)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createWork(v:View) {
        val api : NetwordAPI = Retrofit.Builder()
            .baseUrl("https://kari-api-91by.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetwordAPI::class.java)
        if(bindingCreate.edtName.text.toString().isNotEmpty() &&
            bindingCreate.edtFullScore.text.toString().isNotEmpty()
                ){
            api.createWork(
                bindingCreate.edtName.text.toString(),
                LocalDate.parse(bindingCreate.edtDate.text.toString(),
                    DateTimeFormatter.ISO_DATE),
                bindingCreate.edtFullScore.text.toString().toInt() ,
                "1".toInt() //subject ID
            ).enqueue(object : Callback<CreateWork> {
                override fun onResponse(
                    call: Call<CreateWork>,
                    response: Response<CreateWork>
                ) {
                    if(response.isSuccessful) {
                        Toast.makeText(applicationContext,
                            "Insert Work Success ", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(applicationContext,
                            "Insert Work failed ", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<CreateWork>, t: Throwable) {
                    Toast.makeText(applicationContext,
                        "Error onFailure Work" + t.message, Toast.LENGTH_LONG).show()
                }
            })
        }else{
            Toast.makeText(applicationContext,
                "Please Enter Info", Toast.LENGTH_LONG).show()
        }

    }

    fun selectDate(v:View){
        var newDatePickerFragment = DateTimePickerFragment()
        newDatePickerFragment.show(supportFragmentManager,"Date Picker")
    }
}