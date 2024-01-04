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

    fun getAllNotes(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }
    fun insert(user: Note) {
        viewModelScope.launch {
            noteRepository.insert(user)
        }
    }

}





