import androidx.lifecycle.LiveData

class ContactRepository(private val contactDao: ContactDao) {

    val allContacts: LiveData<List<Contact>> = contactDao.getAllContacts()

    suspend fun insert(contact: Contact) {
        contactDao.insertContact(contact)
    }

    fun sortByNameAsc(): LiveData<List<Contact>> {
        return contactDao.getAllContactsSortedByNameAsc()
    }

    fun sortByNameDesc(): LiveData<List<Contact>> {
        return contactDao.getAllContactsSortedByNameDesc()
    }

    fun searchByName(name: String): LiveData<List<Contact>> {
        return contactDao.searchContactsByName("%$name%")
    }
}
