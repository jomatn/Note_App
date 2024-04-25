package com.example.noteapp.ui.fragment.note

import NoteModel
import android.app.AlertDialog
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.data.OnClick
import com.example.noteapp.data.OnClickItem
import com.example.noteapp.databinding.FragmentNoteBinding
import com.example.noteapp.ui.adapter.NoteAdapter
import com.example.noteapp.utils.App


class NoteFragment() : Fragment(), OnClickItem, OnClick {
    private lateinit var binding: FragmentNoteBinding
    private var noteAdapter = NoteAdapter(this,this)
    private var flag = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)noteAdapter = NoteAdapter(this,this)
        val list = App.appDatabase?.noteDao()?.getAll()
        binding.rvNote.adapter = noteAdapter
        noteAdapter.submitList(list)
        initAdapter()
    }

    override fun onResume() {
        super.onResume()
        updateNoteList()
    }

    private fun initAdapter() = with(binding) {
        btnPlus.setOnClickListener {
            findNavController().navigate(

            )
        }
        imgShape.setOnClickListener {
            if (flag) {
                imgShape.setImageResource()
                binding.rvNote.layoutManager = GridLayoutManager(requireContext(), 2)
                flag = false
            } else {
                imgShape.setImageResource(com.geeks.noteapp.R.drawable.ic_menu)
                binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
                flag = true
            }
        }
    }

    private fun updateNoteList() {
        val notes = App().getInstance()?.noteDao()?.getAll()
        noteAdapter.submitList(notes)
    }

    override fun onLongClick(noteModel: NoteModel) {
        val builder = AlertDialog.Builder(requireContext())
        with(builder) {
            setTitle("Вы точно хотите удалить?")
            setPositiveButton("Да") { dialog, which ->
                App.appDatabase?.noteDao()?.deleteNote(noteModel)
            }
            setNegativeButton("Нет") { dialog, which ->
                dialog.cancel()
            }
            show()
        }
        builder.create()

    }

    override fun onClick(noteModel: NoteModel) {
    }

}