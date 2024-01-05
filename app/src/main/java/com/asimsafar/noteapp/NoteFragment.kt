package com.asimsafar.noteapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.asimsafar.noteapp.databinding.FragmentNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding
    private val viewModel: NoteViewModel by viewModels()
    private lateinit var noteAdapter: NoteAdapter

    fun openAddNotePage() {
        val action = NoteFragmentDirections.actionFragmentToAdd()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        val listView: ListView = binding.noteRecyclerView //ListView id-i

        noteAdapter = NoteAdapter(requireContext())
        listView.adapter = noteAdapter

        binding.noteAddButton.setOnClickListener {
            openAddNotePage()
        }

        viewModel.getAllNotes().observe(viewLifecycleOwner, Observer { notes ->
            noteAdapter.clear()
            noteAdapter.addAll(notes)
            noteAdapter.notifyDataSetChanged()
        })

        return binding.root
    }
}
