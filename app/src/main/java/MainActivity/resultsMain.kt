package MainActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chad.R

class resultsMain : AppCompatActivity() {
    private lateinit var dailyButton: LinearLayout
    private lateinit var weeklyButton: LinearLayout
    private lateinit var monthlyButton: LinearLayout
    private lateinit var homeButton: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.results)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        dailyButton = findViewById(R.id.layoutDaily)
        dailyButton.setOnClickListener {
            opendailyMain()
        }

        weeklyButton = findViewById(R.id.layoutWeekly)
        weeklyButton.setOnClickListener {
            openweeklyMain()
        }

        monthlyButton = findViewById(R.id.layoutMonthly)
        monthlyButton.setOnClickListener {
            openmonthlyMain()
        }

        homeButton = findViewById(R.id.home)
        homeButton.setOnClickListener {
            homeMain()
        }
    }

    // Metoda do otwierania drugiej aktywności
    private fun opendailyMain(){
        val intent = Intent(this, dailyMain::class.java)
        startActivity(intent)
    }

    private fun openweeklyMain(){
        val intent = Intent(this, weeklyMain::class.java)
        startActivity(intent)
    }

    private fun openmonthlyMain(){
        val intent = Intent(this, monthlyMain::class.java)
        startActivity(intent)
    }

    private fun homeMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}