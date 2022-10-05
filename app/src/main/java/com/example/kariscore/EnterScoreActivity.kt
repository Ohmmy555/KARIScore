package com.example.kariscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kariscore.databinding.ActivityEnterScoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class EnterScoreActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEnterScoreBinding
    var studentScoreList = arrayListOf<StudentScore>()
    var studentList = arrayListOf<Users>()
    val createClient = NetwordAPI.create()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterScoreBinding.inflate(layoutInflater)
        setContentView(binding.root )

        binding.recyclerViewScore.layoutManager =
            LinearLayoutManager(applicationContext)
        binding.recyclerViewScore.adapter =
            EnterScoreAdapter(this.studentScoreList, applicationContext)
        binding.recyclerViewScore.addItemDecoration(
            DividerItemDecoration(binding.recyclerViewScore.context,
                DividerItemDecoration.VERTICAL) )



    }

    override fun onResume() {
        super.onResume()
        callStudentScore()
    }

//    fun callSearchStudent(){
//        binding.recyclerViewSearchStudent.addItemDecoration(
//            DividerItemDecoration(binding.recyclerViewSearchStudent.context,
//                DividerItemDecoration.VERTICAL) )
//        binding.recyclerViewSearchStudent.layoutManager =
//            LinearLayoutManager(applicationContext)
//        binding.recyclerViewSearchStudent.adapter =
//            defalutSearchAdapter(applicationContext)
//
//    }

    fun callStudentScore(){
        studentScoreList.clear();
        val serv : NetwordAPI = Retrofit.Builder()
            .baseUrl("https://kari-api-91by.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetwordAPI ::class.java)
        serv.retrieveStudentScore()
            .enqueue(object : Callback<List<StudentScore>> {
                override fun onResponse(call: Call<List<StudentScore>>,
                                        response: Response<List<StudentScore>>) {
                    response.body()?.forEach {
                        studentScoreList.add(StudentScore(it.user_stdid, it.user_name, it.score))
                    }
//// Set Data to RecyclerRecyclerView
                    binding.recyclerViewScore.adapter =
                        EnterScoreAdapter(studentScoreList,applicationContext)
                }
                override fun onFailure(call: Call<List<StudentScore>>, t: Throwable) {
                    Toast.makeText(applicationContext,"Error onFailure" + t.message, Toast.LENGTH_LONG).show()
                }
            })
//        callSearchStudent()
    }




    fun clickSearch(v: View){
        if(binding.edtSearch.text!!.isEmpty()){
            callStudentScore()
        }else{

            createClient.retrieveStudentID(binding.edtSearch.text.toString())
                .enqueue(object : Callback<Users> {
                    override fun onResponse(call: Call<Users>, response: Response<Users>) {
                        if(response.isSuccessful){

                            studentList.add(Users(response.body()?.user_stdid.toString(),
                                response.body()?.user_name.toString()))
                            binding.recyclerViewSearchStudent.adapter= SearchStudentAdapter(studentList,applicationContext)
                        }else{
                            Toast.makeText(applicationContext,"Student ID Not Found",
                                    Toast.LENGTH_LONG).show()
                        }
                    }
                    override fun onFailure(call: Call<Users>, t:
                    Throwable) {
                        Toast.makeText(applicationContext,"Error onFailure" + t.message, Toast.LENGTH_LONG).show()
                    }
                })
        }
    }

}