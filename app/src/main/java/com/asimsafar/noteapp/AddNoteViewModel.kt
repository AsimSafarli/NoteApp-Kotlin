package com.asimsafar.noteapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asimsafar.noteapp.Module.Note
import com.asimsafar.noteapp.Repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel  @Inject constructor (var noteRepository: NoteRepository) :ViewModel() {

    var noteDescription: String = ""
    var noteTitle: String = ""
    var noteType: String = ""
    fun getAllNotes(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }
    fun insert(noteType: String, noteTitle: String, noteDescription: String) {
        val noteToInsert = Note(0, noteType, noteTitle, noteDescription)
        viewModelScope.launch {
            noteRepository.insert(noteToInsert)
        }
    }

}





