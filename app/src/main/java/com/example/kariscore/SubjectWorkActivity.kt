package com.example.kariscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kariscore.databinding.ActivitySubjectWorkBinding

class SubjectWorkActivity : AppCompatActivity() {

    private lateinit var bindingSubjectWork : ActivitySubjectWorkBinding
    var workList = arrayListOf<SubjectWork>()
    var createClient = NetwordAPI.create()

    override fun onCreate(savedInstanceState: Bundle?) {

        bindingSubjectWork = ActivitySubjectWorkBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingSubjectWork.root)

        bindingSubjectWork.SubjectWorks.layoutManager = LinearLayoutManager(applicationContext)
        bindingSubjectWork.SubjectWorks.addItemDecoration(
            DividerItemDecoration(bindingSubjectWork.SubjectWorks.context,
            DividerItemDecoration.VERTICAL)
        )

    }

    override fun onResume() {
        super.onResume()
//        callWorks()
    }

//    fun callWorks(){
//        workList.clear()
//        createClient.insertSubject()
//            .enqueue(object : Callback<List<SubjectA>> {
//                override fun onResponse(
//                    call: Call<List<SubjectA>>,
//                    response: Response<List<SubjectA>>
//                ) {
//                    response.body()?.forEach{
//                        workList.add(SubjectA(
//                            it.subject_id,
//                            it.subject_name,
//                            it.subject_description,
//                            it.subject_term,
//                            it.subject_year))
//                    }
//                    bindingSubject.SubjectWorks.adapter = ""
//                }
//            })
//    }
}