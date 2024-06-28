package MainActivity

import MainActivity.MainActivity
import MainActivity.addMain
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chad.R

class add_sleep_popup : AppCompatActivity() {
    private lateinit var confirmButton: LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_sleep_popup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val seekBarStartSleep: SeekBar = findViewById(R.id.seekBarStartSleep)
        val seekBarStopSleep: SeekBar = findViewById(R.id.seekBarStopSleep)

        confirmButton = findViewById(R.id.confirm)
        confirmButton.setOnClickListener {
            addMain()
        }

        seekBarStartSleep.max = 24  // Ustawienie maksymalnej wartości paska na 24


        seekBarStartSleep.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var lastProgress = 0

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    // Jeśli zmiana pochodzi od użytkownika, sprawdź kierunek przesunięcia
                    if (progress < lastProgress) {
                        // Przesunięcie w lewo, zmniejsz wartość paska o 1
                        seekBar?.progress = progress - 1
                    } else {
                        // Przesunięcie w prawo, zwiększ wartość paska o 1
                        seekBar?.progress = progress + 1
                    }
                    lastProgress = seekBar?.progress ?: 0
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Obsługa rozpoczęcia przesuwania paska
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Obsługa zakończenia przesuwania paska
            }
        })

        seekBarStopSleep.max = 24

        seekBarStopSleep.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var lastProgress = 0

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    // Jeśli zmiana pochodzi od użytkownika, sprawdź kierunek przesunięcia
                    if (progress < lastProgress) {
                        // Przesunięcie w lewo, zmniejsz wartość paska o 1
                        seekBar?.progress = progress - 1
                    } else {
                        // Przesunięcie w prawo, zwiększ wartość paska o 1
                        seekBar?.progress = progress + 1
                    }
                    lastProgress = seekBar?.progress ?: 0
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Obsługa rozpoczęcia przesuwania paska
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Obsługa zakończenia przesuwania paska
            }
        })

    }


}








