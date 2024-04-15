package com.example.noteapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.databinding.FragmentOnBoardPagingBinding

data class OnBoardItem(val text: String, val animationResId: Int)

class OnBoardAdapter : RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    private var items = emptyList<OnBoardItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        val binding = FragmentOnBoardPagingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnBoardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun submitList(newItems: List<OnBoardItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class OnBoardViewHolder(private val binding: FragmentOnBoardPagingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OnBoardItem) {
            binding.tvOn.text = item.text
            binding.lottie.setAnimation(item.animationResId)
        }
    }
}
