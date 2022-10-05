package com.example.kariscore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kariscore.databinding.InputScoreItemBinding
import com.example.kariscore.databinding.ScoreItemLayoutBinding

class EnterScoreAdapter (val items :List<StudentScore>, val context: Context):
    RecyclerView.Adapter<EnterScoreAdapter.ViewHolder>() {
        inner class ViewHolder(view: View, val binding: ScoreItemLayoutBinding) :
            RecyclerView.ViewHolder(view) {
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                ViewHolder {
            val binding = ScoreItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false)
            return ViewHolder(binding.root, binding)
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val binding_holder = holder.binding
            binding_holder.stdID.text = items[position].user_stdid
            binding_holder.stdName.text = items[position].user_name
            binding_holder.stdScore.text = items[position].score.toString()

        }
        override fun getItemCount(): Int {
            return items.size
        }
    }
