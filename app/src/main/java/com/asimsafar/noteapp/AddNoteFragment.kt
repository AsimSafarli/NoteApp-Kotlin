package com.asimsafar.noteapp

import AddNoteViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.asimsafar.noteapp.Module.Note
import com.asimsafar.noteapp.databinding.FragmentAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment() {
    lateinit var binding:FragmentAddNoteBinding
    val viewModel = AddNoteViewModel by viewModels()
    fun backToNotePage(){
        val action = AddNoteFragmentDirections.actionAddToNote()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val noteToInsert = Note(0, "animals", "cat", "cat eat meal")
        binding.noteToHomePage.setOnClickListener {
            backToNotePage()
        }
        return binding.root
    }
}
