package com.asimsafar.noteapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.asimsafar.noteapp.Module.Note
import com.asimsafar.noteapp.Repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
    fun getAllNotes(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }
}