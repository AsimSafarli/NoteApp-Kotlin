package com.asimsafar.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.asimsafar.noteapp.databinding.FragmentNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class NoteFragment : Fragment() {
   lateinit var  binding :FragmentNoteBinding
    fun openAddNotePage(){
        val action = NoteFragmentDirections.actionFragmentToAdd()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentNoteBinding.inflate(inflater)
        binding.noteAddButton.setOnClickListener{
            openAddNotePage()
        }

        return  binding.root
    }

}