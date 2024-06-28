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

class Morning : AppCompatActivity() {
    private lateinit var home: ImageView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MedicationAdapterMorning
    private lateinit var medicationsList: List<Medication>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morning)

        recyclerView = findViewById(R.id.recyclerViewMORNING)
        home = findViewById(R.id.homeMorning)

        medicationsList = loadMedications()
        adapter = MedicationAdapterMorning(medicationsList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        home.setOnClickListener{
            homeMain()
        }
    }

    private fun loadMedications(): List<Medication> {
        return listOf(
            Medication(drugName = "Aspirin", dosage = 200.0, unit = "mg"),
            Medication(drugName = "Ibuprofen", dosage = 400.0, unit = "mg"),
            Medication(drugName = "Paracetamol", dosage = 500.0, unit = "mg"),
            Medication(drugName = "Metformin", dosage = 850.0, unit = "mg"),
            Medication(drugName = "Amoxicillin", dosage = 250.0, unit = "mg")
        )
    }

    private fun homeMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}