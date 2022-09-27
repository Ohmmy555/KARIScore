package com.example.kariscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.kariscore.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var subjectList = arrayListOf<Subject>()
    val createClient = NetwordAPI.create()
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root )
        binding.recyclerViewSubject.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewSubject.addItemDecoration(
            DividerItemDecoration(binding.recyclerViewSubject.context,
                DividerItemDecoration.VERTICAL) )

    }
    override fun onResume() {
        super.onResume()
        swipeRefreshLayout = findViewById(R.id.swipe_layout)
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            callSubject()
            Handler().postDelayed(Runnable {
            }, 3000)
        }
        callSubject()

    }

    fun callSubject(){
        subjectList.clear()
        createClient.retrieveSubject().enqueue(object : Callback<List<Subject>> {
                override fun onResponse(
                    call: Call<List<Subject>>,
                    response: Response<List<Subject>>
                ) {
                    response.body()?.forEach {
                        subjectList.add(Subject(it.id,it.name,it.year,it.team))
                    }
                    binding.recyclerViewSubject.adapter = ShowSubjectAdapter(subjectList, applicationContext)
                }

                override fun onFailure(call: Call<List<Subject>>, t: Throwable) {
                    t.printStackTrace()
                    Toast.makeText(applicationContext,"Error2", Toast.LENGTH_LONG).show()
                }
            })
}


}

