package com.asimsafar.noteapp
// NoteFragment.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.asimsafar.noteapp.databinding.FragmentNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding
    private val viewModel: NoteViewModel by viewModels()
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)

        noteAdapter = NoteAdapter(requireContext())
        binding.noteRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.noteRecyclerView.adapter = noteAdapter

        viewModel.getAllNotes().observe(viewLifecycleOwner, Observer { notes ->
            noteAdapter.submitList(notes)
        })

        return binding.root
    }
}
