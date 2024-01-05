package com.asimsafar.noteapp
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.asimsafar.noteapp.Module.Note

class NoteAdapter(context: Context) : ArrayAdapter<Note>(context, R.layout.item_note) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            val inflater = LayoutInflater.from(context)
            itemView = inflater.inflate(R.layout.item_note, parent, false)
        }

        val textTitle: TextView = itemView!!.findViewById(R.id.textTitle)
            ?: throw NullPointerException("textTitle view not found in layout")
        val textDescription: TextView = itemView.findViewById(R.id.textDescription)
            ?: throw NullPointerException("textDescription view not found in layout")

        val currentNote = getItem(position)
        textTitle.text = currentNote?.noteTitle
        textDescription.text = currentNote?.noteDescrb

        return itemView
    }
}
