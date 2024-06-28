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
import MainActivity.monthlyMain

class resultsMain : AppCompatActivity() {
    private lateinit var weeklyButton: LinearLayout
    private lateinit var monthlyButton: LinearLayout
    private lateinit var home: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results_main)

        home = findViewById(R.id.homeResults)

        home.setOnClickListener {
            homeMain()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        weeklyButton = findViewById(R.id.layoutWeekly)
        weeklyButton.setOnClickListener {
            openweeklyMain()
        }

        monthlyButton = findViewById(R.id.layoutMonthly)
        monthlyButton.setOnClickListener {
            openmonthlyMain()
        }

    }

    private fun openweeklyMain() {
        val intent = Intent(this, weeklyMain::class.java)
        startActivity(intent)
    }
    private fun openmonthlyMain() {
        val intent = Intent(this, monthlyMain::class.java)
        startActivity(intent)
    }

    private fun homeMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}







