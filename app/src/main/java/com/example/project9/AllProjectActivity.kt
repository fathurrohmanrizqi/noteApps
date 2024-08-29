package com.example.project9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AllProjectActivity : AppCompatActivity() {
    private lateinit var btnPrjct1: Button
    private lateinit var btnPrjct2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_all_project)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initializeBtn()
        setOnClickListener()
    }
    private fun initializeBtn(){
        btnPrjct1 = findViewById<Button>(R.id.btnPrjct1)
        btnPrjct2 = findViewById<Button>(R.id.btnPrjct2)
    }
    private fun setOnClickListener(){
        btnPrjct1.setOnClickListener {
            intent = Intent(this, CatatanAppsActivity::class.java)
            startActivity(intent)
        }
        btnPrjct2.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}