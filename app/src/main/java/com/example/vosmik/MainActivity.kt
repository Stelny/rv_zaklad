package com.example.vosmik

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.ListAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vosmik.Adapters.NoteAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        recycler_view.layoutManager = LinearLayoutManager(this)

        recycler_view.setHasFixedSize(true)

        val db = DataBaseHandler(context)
        val noteList =  db.readData()


        recycler_view.adapter = NoteAdapter(noteList.reversed())

        val fab = findViewById<FloatingActionButton>(R.id.floating_buttons_add)
        fab.setOnClickListener {
            val intent = Intent(context, AddNoteActivity::class.java);
            startActivity(intent)
        }
    }


}

