package com.asimsafar.noteapp.Repository

import androidx.lifecycle.LiveData
import com.asimsafar.noteapp.Daos.NoteDao
import com.asimsafar.noteapp.Interfaces.NoteInterface
import com.asimsafar.noteapp.Module.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private  val noteDao: NoteDao):NoteInterface {
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }
    fun getAllNotes() : LiveData<List<Note>> {
        return noteDao.getAllNotes()
    }
}