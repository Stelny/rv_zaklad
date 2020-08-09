package com.example.vosmik.Adapters

import android.content.Context
import android.content.Intent
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.vosmik.EditNoteActivity
import com.example.vosmik.Models.Notes
import com.example.vosmik.R
import kotlinx.android.synthetic.main.add_note.view.*
import kotlinx.android.synthetic.main.example_item.view.*
import java.nio.file.Files.size

class NoteAdapter(private val note: List<Notes>): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.example_item,parent,false)
        return NoteViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val currentItem = note[position]
        holder.heading.text = currentItem.heading
        holder.content.text = currentItem.content
        holder.notes = currentItem
    }

    override fun getItemCount() = note.size

    class NoteViewHolder(itemView: View, var notes: Notes? = null) : RecyclerView.ViewHolder(itemView) {
        val heading: TextView = itemView.about
        val content: TextView = itemView.lorem
        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, EditNoteActivity::class.java)
                intent.putExtra("id",notes?.id)
                intent.putExtra("heading",notes?.heading)
                intent.putExtra("content",notes?.content)
                itemView.context.startActivity(intent)
            }
        }




    }

}


