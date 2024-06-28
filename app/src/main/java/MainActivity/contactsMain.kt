package MainActivity


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chad.R
import MainActivity.Contact

class contactsMain : AppCompatActivity() {
    private lateinit var addButton: LinearLayout
    private lateinit var home: ImageButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contactsList: List<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_main)

        // Initialize UI elements
        addButton = findViewById(R.id.linearLayout2)
        home = findViewById(R.id.imageButton)
        recyclerView = findViewById(R.id.recyclerViewCONTACTS)

        // Set up RecyclerView
        contactsList = loadContacts() // Load your contacts here
        contactAdapter = ContactAdapter(contactsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = contactAdapter

        // Set up button listeners
        addButton.setOnClickListener {
            openAddMain()
        }

        home.setOnClickListener {
            homeMain()
        }
    }

    // Dummy method to load contacts
    private fun loadContacts(): List<Contact> {
        // Return a list of contacts here
        return listOf(
            Contact(name = "John", surname = "Doe", phoneNumber = 123456789, address = "123 Street", tag = "Doctor"),
            Contact(name = "Jane", surname = "Smith", phoneNumber = 987654321, address = "456 Avenue", tag = "Therapist")
        )
    }

    private fun openAddMain() {
        val intent = Intent(this, add::class.java)
        startActivity(intent)
    }

    private fun homeMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}