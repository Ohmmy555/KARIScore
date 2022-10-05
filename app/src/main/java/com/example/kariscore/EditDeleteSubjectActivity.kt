package com.example.kariscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kariscore.databinding.ActivityEditDeleteSubjectBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditDeleteSubjectActivity : AppCompatActivity() {
    private lateinit var bindingEditDelete : ActivityEditDeleteSubjectBinding
    val createClient = NetwordAPI.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_delete_subject)

        bindingEditDelete =
            ActivityEditDeleteSubjectBinding.inflate(layoutInflater)
        setContentView(bindingEditDelete.root)
        val mId = intent.getStringExtra("mID")
        val mName = intent.getStringExtra("mName")
        val mYear = intent.getStringExtra("mYear")
        val mTerm = intent.getStringExtra("mTerm")
        val mDetail = intent.getStringExtra("mDetail")
        bindingEditDelete.edtName.setText(mName)
        bindingEditDelete.edtYear.setText(mYear)
        bindingEditDelete.edtTerm.setText(mTerm)
        bindingEditDelete.edtDetail.setText(mDetail)

    }
    fun saveEditSubject(v: View) {
        createClient.updateStudent(
            bindingEditDelete.edtName.text.toString(),
            bindingEditDelete.edtYear.text.toString().toInt(),
            bindingEditDelete.edtTerm.text.toString().toInt(),
            bindingEditDelete.edtDetail.text.toString()
        ).enqueue(object : Callback<SubjectWork> {
            override fun onResponse(call: Call<SubjectWork>, response:
            Response<SubjectWork>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText( applicationContext, "Seccessfully Updated",
                            Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, " Update Failure",
                        Toast.LENGTH_LONG)
                        .show()
                }
            }
            override fun onFailure(call: Call<SubjectWork>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure " +
                        t.message,
                    Toast.LENGTH_LONG).show()
            }
        })
    }
    fun deleteSubject(v: View) {
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.apply {
            setTitle("Warning")
            setMessage("Do you want to delete Subject?")
            setNegativeButton("Yes") { dialog, which ->
                val mID = intent.getStringExtra("mId")
                createClient.deleteSubject(mID.toString())
                    .enqueue(object : Callback<SubjectWork> {
                        override fun onResponse(call: Call<SubjectWork>,
                                                response: Response<SubjectWork>) {
                            if (response.isSuccessful) {
                                Toast.makeText(applicationContext,
                                    "Successfully Deleted", Toast.LENGTH_LONG).show()
                            }
                        }
                        override fun onFailure(call: Call<SubjectWork>, t:
                        Throwable) {
                            Toast.makeText(applicationContext, t.message,
                                Toast.LENGTH_LONG).show()
                        }
                    })
                finish()
            }
            setPositiveButton ("No"){ dialog, which ->dialog.cancel()}
            show()
        }
    }

    }
