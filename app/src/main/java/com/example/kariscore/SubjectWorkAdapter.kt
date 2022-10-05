package com.example.kariscore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kariscore.databinding.SubjectWorksItemLayoutBinding

class SubjectWorkAdapter(val items :List<Score>, val context: Context):
    RecyclerView.Adapter<SubjectWorkAdapter.ViewHolder>() {
    inner class ViewHolder(view: View, val binding: SubjectWorksItemLayoutBinding) :
        RecyclerView.ViewHolder(view) {
        init {
            binding.EnterScore.setOnClickListener {
                val item = items[adapterPosition]
                val contextView:Context = view.context
                val intent = Intent(contextView, EnterScoreActivity::class.java)
                intent.putExtra("mId",item.score_id)
                contextView.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SubjectWorksItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding.root, binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding_holder = holder.binding
        binding_holder.NameWorks.text = items[position].score_name
        binding_holder.DateWorks.text = items[position].score_date.substring(0,10)
    }
    override fun getItemCount(): Int {
        return items.size
    }
}
