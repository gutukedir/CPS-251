import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository

    val allContacts: LiveData<List<Contact>>

    init {
        val contactDao = ContactRoomDatabase.getDatabase(application).contactDao()
        repository = ContactRepository(contactDao)
        allContacts = repository.allContacts
    }

    fun insert(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(contact)
        }
    }

    fun sortByNameAsc(): LiveData<List<Contact>> {
        return repository.sortByNameAsc()
    }

    fun sortByNameDesc(): LiveData<List<Contact>> {
        return repository.sortByNameDesc()
    }

    fun searchByName(name: String): LiveData<List<Contact>> {
        return repository.searchByName(name)
    }
}
