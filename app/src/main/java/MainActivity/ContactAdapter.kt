package MainActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chad.R
import com.example.chad.models.Contact

class ContactAdapter(private val contactsList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactsList[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameC)
        private val surnameTextView: TextView = itemView.findViewById(R.id.Surname)
        private val phoneTextView: TextView = itemView.findViewById(R.id.phoneC)
        private val addressTextView: TextView = itemView.findViewById(R.id.adressC)
        private val tagTextView: TextView = itemView.findViewById(R.id.tag)

        fun bind(contact: Contact) {
            nameTextView.text = contact.name
            surnameTextView.text = contact.surname
            phoneTextView.text = contact.phoneNumber.toString()
            addressTextView.text = contact.address
            tagTextView.text = contact.tag
        }
    }
}
