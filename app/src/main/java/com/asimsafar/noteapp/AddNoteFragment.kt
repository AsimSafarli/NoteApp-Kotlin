package com.asimsafar.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asimsafar.noteapp.AddNoteViewModel
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.asimsafar.noteapp.Module.Note
import com.asimsafar.noteapp.databinding.FragmentAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment() {
    val viewModel: AddNoteViewModel by viewModels()
    lateinit var binding: FragmentAddNoteBinding


    fun backToNotePage() {
        val action = AddNoteFragmentDirections.actionAddToNote()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.noteToHomePage.setOnClickListener {
            backToNotePage()
        }

        binding.noteSaveButton.setOnClickListener {
            val noteType = binding.noteType.text.toString()
            val noteTitle = binding.noteTitle.text.toString()
            val noteDescription = binding.noteDescribe.text.toString()
            viewModel.insert(noteType,noteTitle,noteDescription)

            viewModel.getAllNotes().observe(viewLifecycleOwner, Observer {

            })
            backToNotePage()
        }

        return binding.root
    }
}

