package com.example.vosmik

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.vosmik.Models.Notes

val DATABASE_NAME = "notes"
val TABLE_NAME = "notes"
val COL_HEADING = "heading"
val COL_CONTENT = "content"
val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,1) {
    override fun onCreate(db: SQLiteDatabase?) {


        val createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + COL_HEADING + " VARCHAR(256), " + COL_CONTENT + " VARCHAR(256))";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(notes: Notes) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_HEADING, notes.heading)
        cv.put(COL_CONTENT, notes.content)
        val result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
    fun readData() : MutableList<Notes> {
        val list : MutableList<Notes> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val result = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val note = Notes()
                note.id = result.getString(0).toInt()
                note.heading = result.getString(1)
                note.content = result.getString(2)
                list.add(note)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }
    fun rewriteData(id: Int, heading: String, content: String) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_HEADING, heading)
        cv.put(COL_CONTENT, content)
        db.update(TABLE_NAME, cv, "$COL_ID=?", arrayOf(id.toString()))

    }

}