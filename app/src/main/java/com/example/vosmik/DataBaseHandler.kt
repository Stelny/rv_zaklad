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


        val createTable = "CREATE TABLE" + TABLE_NAME + "(" + COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + COL_HEADING + "VARCHAR(256), " + COL_CONTENT + " VARCHAR(256)";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(notes: Notes) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_HEADING, notes.heading)
        cv.put(COL_CONTENT, notes.content)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

}