package com.example.kariscore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kariscore.databinding.ActivityMainItemBinding

class ShowSubjectAdapter(val items :List<Subject>, val context: Context):
    RecyclerView.Adapter<ShowSubjectAdapter.ViewHolder>() {
    inner class ViewHolder(view: View, val binding: ActivityMainItemBinding) :
        RecyclerView.ViewHolder(view) {
        init {
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityMainItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding_holder = holder.binding
        binding_holder.TitleSubject.text = items[position].name
        binding_holder.textYear.text = items[position].year
        binding_holder.textTeam.text = items[position].team
    }

    override fun getItemCount(): Int {
        return items.size
    }
}