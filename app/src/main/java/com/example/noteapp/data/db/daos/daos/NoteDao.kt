package com.example.noteapp.data.db.daos.daos

import NoteModel
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Query("SELECT * FROM noteModel")
    fun  getAll(): LiveData<List<NoteModel>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteModel: NoteModel)

    @Delete
    fun deleteNote(noteModel: NoteModel)

    @Update
    fun update(noteModel: NoteModel)
}