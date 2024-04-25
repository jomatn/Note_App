package com.example.noteapp.data

import NoteModel


interface OnClickItem {
    fun onLongClick(noteModel: NoteModel)
}