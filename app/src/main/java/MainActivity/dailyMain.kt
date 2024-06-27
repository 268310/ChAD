package MainActivity

/**
package com.example.yourapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chad.R

open class dailyMain : AppCompatActivity() {

    // Mapy przechowujące dane
    private val data = mutableMapOf<String, Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Przykładowe dodanie danych
        add("date", "2024-06-24")
        add("energy", "High")
        add("mood", 80)
        add("sleep", 6)
        add("activity", "Running")

        // Wyświetlenie danych
        display()
    }

    // Funkcja do dodawania danych
    private fun add(key: String, value: Any) {
        data[key] = value
    }

    // Funkcja do wyświetlania danych
    fun display() {
        val dateTextView: TextView = findViewById(R.id.dateTextView)
        val energyTextView: TextView = findViewById(R.id.energy)
        val moodSeekBar: SeekBar = findViewById(R.id.seekBar)
        val sleepProgressBar: ProgressBar = findViewById(R.id.progressBar2)
        val activityTextView: TextView = findViewById(R.id.activity)

        // Wyświetlanie daty
        dateTextView.text = data["date"] as? String ?: "No Date"

        // Wyświetlanie energii
        energyTextView.text = data["energy"] as? String ?: "No Data"

        // Wyświetlanie nastroju
        moodSeekBar.progress = data["mood"] as? Int ?: 0

        // Wyświetlanie snu
        sleepProgressBar.progress = (data["sleep"] as? Int ?: 0) * 10

        // Wyświetlanie aktywności
        activityTextView.text = data["activity"] as? String ?: "No Activity"
    }
}
*/