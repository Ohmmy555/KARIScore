package com.example.kariscore

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*

class DateTimePickerFragment:
    DialogFragment(),DatePickerDialog.OnDateSetListener {
    private lateinit var calendar: Calendar

    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MINUTE)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(),0,this,year,month,day)
    }

    override fun onCancel(dialog: DialogInterface) {
        Toast.makeText(activity,"mm - dd - yy",Toast.LENGTH_LONG).show()
        super.onCancel(dialog)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        var daynew : String = if(day<10) "0${day.toString()}" else
            day.toString()
        var monthnew : String = if(month+1<10) "0${(month+1).toString()}"
        else (month+1).toString()
        requireActivity().findViewById<TextView>(R.id.edtDate).text = "$year-$daynew-$monthnew"
    }
}