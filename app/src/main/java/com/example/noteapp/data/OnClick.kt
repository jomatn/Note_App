package com.example.noteapp.data

import NoteModel


interface OnClick {
    fun onClick(noteModel: NoteModel)
}