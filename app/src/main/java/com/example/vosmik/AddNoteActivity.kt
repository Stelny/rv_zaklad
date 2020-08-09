package com.example.vosmik

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vosmik.Models.Notes
import kotlinx.android.synthetic.main.add_note.*

class AddNoteActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

        val add_note = findViewById<Button>(R.id.add_note)
        val etvHeading = findViewById<EditText>(R.id.etvHeading)
        val etvContent = findViewById<EditText>(R.id.etvContent)
        val context = this
        val db = DataBaseHandler(context)
        add_note.setOnClickListener {
            if (etvHeading.text.toString().isNotEmpty() && etvContent.text.toString().isNotEmpty()) {
                val note = Notes(etvHeading.text.toString(),etvContent.text.toString())
                db.insertData(note)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Vyplnte pole", Toast.LENGTH_SHORT).show()
            }
        }
    }
}