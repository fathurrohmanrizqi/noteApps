package com.example.project9

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class TambahCatatanAct : AppCompatActivity() {
    private lateinit var btnSaved: Button
    private lateinit var editTxtFileName: EditText
    private lateinit var editTxtNote: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tambah_catatan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initializeNotes()
        setOnClickListener()
        //back button
        val toolbar: Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Register"
    }
    //back button
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun initializeNotes(){
        btnSaved = findViewById(R.id.btnSaved)
        editTxtFileName = findViewById(R.id.editTxtFileName)
        editTxtNote = findViewById(R.id.editTxtNote)
    }
    private fun setOnClickListener(){
        btnSaved.setOnClickListener {
            writeTextToFile(this, editTxtFileName.text.toString(), editTxtNote.text.toString())
            finish()
        }
    }
    private fun writeTextToFile(context: Context, filename: String, content: String) {
        val file = File(context.filesDir, filename)
        try {
            FileOutputStream(file).use { outputStream ->
                outputStream.write(content.toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}