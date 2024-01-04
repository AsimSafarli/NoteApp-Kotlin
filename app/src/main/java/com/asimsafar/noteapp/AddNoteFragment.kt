package com.asimsafar.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.asimsafar.noteapp.databinding.FragmentAddNoteBinding


class AddNoteFragment : Fragment() {
   lateinit var binding:FragmentAddNoteBinding

    fun backToNotePage(){
        val action =AddNoteFragmentDirections.actionAddToNote()
        findNavController().navigate(action)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentAddNoteBinding.inflate(inflater)
        binding.noteToHomePage.setOnClickListener {
            backToNotePage()
        }
        return binding.root
    }

}