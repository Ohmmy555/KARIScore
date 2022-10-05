package com.example.kariscore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kariscore.databinding.DefaultInputItemBinding

class defalutSearchAdapter (val context: Context):
    RecyclerView.Adapter<defalutSearchAdapter.ViewHolder>() {
    inner class ViewHolder(view: View, val binding: DefaultInputItemBinding) :
        RecyclerView.ViewHolder(view) {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val binding = DefaultInputItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding_holder = holder.binding
        binding_holder.stdId.text = "ID :"
        binding_holder.stdFullName.text = "Name :"    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}