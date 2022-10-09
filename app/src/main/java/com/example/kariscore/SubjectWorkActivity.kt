package com.example.kariscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kariscore.databinding.ActivitySubjectWorkBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SubjectWorkActivity : AppCompatActivity() {
    private lateinit var bindingSubjectWork: ActivitySubjectWorkBinding
    var scorelist = arrayListOf<Score>()
    val createClient = NetwordAPI.create()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSubjectWork = ActivitySubjectWorkBinding.inflate(layoutInflater)
        setContentView(bindingSubjectWork.root)
        bindingSubjectWork.recyclerViewSubjectWorks.layoutManager =
            LinearLayoutManager(applicationContext)
        bindingSubjectWork.recyclerViewSubjectWorks.adapter=
            SubjectWorkAdapter(this.scorelist,applicationContext)
        bindingSubjectWork.recyclerViewSubjectWorks.addItemDecoration(
            DividerItemDecoration(bindingSubjectWork.recyclerViewSubjectWorks.context,
                DividerItemDecoration.VERTICAL)
        )

    }

    override fun onResume() {
        super.onResume()
        callScore()
    }

    fun callScore() {
        scorelist.clear()
        createClient.retrieveScore().enqueue(object : Callback<List<Score>> {
            override fun onResponse(
                call: Call<List<Score>>,
                response: Response<List<Score>>
            ) {
                response.body()?.forEach {
                    scorelist.add(Score(it.score_id, it.score_name, it.score_date))
                }
                bindingSubjectWork.recyclerViewSubjectWorks.adapter =
                    SubjectWorkAdapter(scorelist, applicationContext)
            }

            override fun onFailure(call: Call<List<Score>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(applicationContext, "Error2", Toast.LENGTH_LONG).show()
            }
        })
    }



//
//
//        scorelist.clear();
//        val serv: NetwordAPI = Retrofit.Builder()
//            .baseUrl("https://kari-api-91by.vercel.app/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(NetwordAPI::class.java)
//        serv.retrieveScore()
//            .enqueue(object : Callback<List<Score>> {
//                override fun onResponse(call: Call<List<Score>>,
//                    response: Response<List<Score>> ) {
//                    response.body()?.forEach {
//                        scorelist.add(Score( it.score_id, it.score_name, it.score_date))
//                    }
//                    //// Set Data to RecyclerRecyclerView
//                    bindingSubjectWork.recyclerViewSubjectWorks.adapter = SubjectWorkAdapter(scorelist, applicationContext)
//                }
//
//                override fun onFailure(call: Call<List<Score>>, t: Throwable) {
//                    Toast.makeText(applicationContext, "Error onFailure " + t.message, Toast.LENGTH_LONG
//                    ).show()
//                }
//            })
//
//
//    }
}