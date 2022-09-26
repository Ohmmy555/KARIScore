package com.example.kariscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kariscore.databinding.ActivitySubjectBinding

class SubjectActivity : AppCompatActivity() {

    private lateinit var bindingSubject : ActivitySubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        bindingSubject = ActivitySubjectBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingSubject.root)
    }
}