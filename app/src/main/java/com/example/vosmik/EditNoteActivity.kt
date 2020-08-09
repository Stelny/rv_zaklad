package com.example.vosmik

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_note.*

class EditNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

        val context = this

        val id = intent.getIntExtra("id", 0)
        val heading = intent.getStringExtra("heading")
        val content = intent.getStringExtra("content")
        
        val etvH = findViewById<EditText>(R.id.etvHeading)
        val etvC = findViewById<EditText>(R.id.etvContent)

        etvC.setText(content)
        etvH.setText(heading)

        add_note.setOnClickListener {
            val db = DataBaseHandler(context)
            db.rewriteData(id, etvH.text.toString(), etvC.text.toString())

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }
}