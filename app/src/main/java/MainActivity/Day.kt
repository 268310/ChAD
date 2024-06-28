package MainActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chad.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Day : AppCompatActivity() {
    private lateinit var home: ImageView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MedicationAdapterDay
    private lateinit var medicationsList: List<Medication>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        recyclerView = findViewById(R.id.recyclerViewDAY)
        home = findViewById(R.id.homeDay)

        medicationsList = loadMedications()
        adapter = MedicationAdapterDay(medicationsList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        home.setOnClickListener{
            homeMain()
        }
    }

    private fun loadMedications(): List<Medication> {
        return listOf(
            Medication(drugName = "Lisinopril", dosage = 10.0, unit = "mg"),
            Medication(drugName = "Simvastatin", dosage = 20.0, unit = "mg"),
            Medication(drugName = "Levothyroxine", dosage = 50.0, unit = "mcg"),
            Medication(drugName = "Amlodipine", dosage = 5.0, unit = "mg"),
            Medication(drugName = "Omeprazole", dosage = 40.0, unit = "mg")
        )
    }

    private fun homeMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}