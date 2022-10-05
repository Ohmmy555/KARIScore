package com.example.kariscore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kariscore.databinding.InputScoreItemBinding

class SearchStudentAdapter(val item :List<Users>, val context: Context):
    RecyclerView.Adapter<SearchStudentAdapter.ViewHolder>() {
    inner class ViewHolder(view: View, val binding: InputScoreItemBinding) :
        RecyclerView.ViewHolder(view) {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val binding = InputScoreItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding.root, binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding_holder = holder.binding
        binding_holder.stdId.text = item[position].user_stdid
        binding_holder.stdFullName.text = item[position].user_name
    }
    override fun getItemCount(): Int {
        return item.size
    }
}