package com.asimsafar.noteapp.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.asimsafar.noteapp.Module.Note

@Dao
interface NoteDao {
  //push
    @Insert
    suspend fun insert(note:Note)

    @Query("SELECT*FROM note")
    fun getAllNotes():LiveData<List<Note>>

    @Delete
    suspend fun delete(note:Note)
}