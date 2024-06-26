package com.example.chad

import MainActivity.MainActivity
import MainActivity.addMain
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class add_sleep_popup : AppCompatActivity() {
    private lateinit var confirmButton: LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sleep_popup)

        // Włączanie wyświetlania od brzegu do brzegu ekranu
        enableEdgeToEdge()

        // Ustawienie paddingu na podstawie pasków systemowych
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        confirmButton = findViewById(R.id.confirm)
        confirmButton.setOnClickListener {
            addMain()
        }

        // Inicjalizacja spinnera
        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.yesno,
            R.layout.spinner_list
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun enableEdgeToEdge() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    private fun addMain(){
        val intent = Intent(this, addMain::class.java)
        startActivity(intent)
    }


}
