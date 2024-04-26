import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsproject.R

class MainActivity : AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel
    private lateinit var adapter: ContactListAdapter

    private lateinit var editTextName: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextSearch: EditText
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextSearch = findViewById(R.id.editTextSearch)
        recyclerView = findViewById(R.id.recyclerview)

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        adapter = ContactListAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        contactViewModel.allContacts.observe(this, Observer { contacts ->
            contacts?.let { adapter.submitList(it) }
        })
    }

    fun addContact(view: View) {
        val name = editTextName.text.toString()
        val phone = editTextPhone.text.toString()

        if (name.isNotBlank() && phone.isNotBlank()) {
            contactViewModel.insert(Contact(contactName = name, contactPhone = phone))
        } else {
            Toast.makeText(this, "Please enter name and phone number", Toast.LENGTH_SHORT).show()
        }
    }

    fun sortAsc(view: View) {
        contactViewModel.sortByNameAsc()
    }

    fun sortDesc(view: View) {
        contactViewModel.sortByNameDesc()
    }

    fun searchContact(view: View) {
        val searchTerm = editTextSearch.text.toString()
        if (searchTerm.isNotBlank()) {
            contactViewModel.searchByName(searchTerm)
        } else {
            Toast.makeText(this, "Please enter a search criteria", Toast.LENGTH_SHORT).show()
        }
    }
}
