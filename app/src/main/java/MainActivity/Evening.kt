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

class Evening : AppCompatActivity() {
    private lateinit var home: ImageView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MedicationAdapterEvening
    private lateinit var medicationsList: List<Medication>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evening)

        recyclerView = findViewById(R.id.recyclerViewEVENING)
        home = findViewById(R.id.homeEvening)

        medicationsList = loadMedications()
        adapter = MedicationAdapterEvening(medicationsList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        home.setOnClickListener{
            homeMain()
        }
    }

    private fun loadMedications(): List<Medication> {
        return listOf(
            Medication(drugName = "Hydrochlorothiazide", dosage = 25.0, unit = "mg"),
            Medication(drugName = "Atorvastatin", dosage = 10.0, unit = "mg"),
            Medication(drugName = "Metoprolol", dosage = 50.0, unit = "mg"),
            Medication(drugName = "Losartan", dosage = 100.0, unit = "mg"),
            Medication(drugName = "Gabapentin", dosage = 300.0, unit = "mg")
        )
    }

    private fun homeMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}