package com.example.noteapp.ui.adapter

import NoteModel
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.data.OnClick
import com.example.noteapp.data.OnClickItem
import com.example.noteapp.databinding.NoteItemBinding

class NoteAdapter(private val onLongClick: OnClickItem, private val onClick: OnClick) :
    ListAdapter<NoteModel, NoteAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NoteItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnLongClickListener {
            onLongClick.onLongClick(getItem(position))
            true
        }
        /*holder.itemView.setOnClickListener {
            onClick.onClick(getItem(position))
        }*/
    }


    class ViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(noteModel: NoteModel?) {
            binding.apply {
                tvTime.text = noteModel?.time
                tvText.text = noteModel?.text
                tvTitle.text = noteModel?.title
                tvDate.text = noteModel?.date
                if (noteModel != null) {
                    itemView.setBackgroundColor(noteModel.color)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.title == newItem.title && oldItem.text == newItem.text
        }
    }
}