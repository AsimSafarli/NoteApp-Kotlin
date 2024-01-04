package com.asimsafar.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asimsafar.noteapp.AddNoteViewModel
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.asimsafar.noteapp.Module.Note
import com.asimsafar.noteapp.databinding.FragmentAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment() {
//    val viewModel: AddNoteViewModel by viewModels()
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
//        binding.viewModel = viewModel
//        binding.lifecycleOwner = this
//        val noteToInsert = Note(0, "animals", "cat", "cat eat meal")
////        viewModel.insert(noteToInsert)
        binding.noteToHomePage.setOnClickListener {
            backToNotePage()
        }
        return binding.root
    }
}
