// com.example.savedataproject2.NamesViewModel
import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableField
import java.util.ArrayList

class NamesViewModel : ViewModel() {

    val names = ArrayList<String>()
    val nameInput = ObservableField<String>("")

    fun onSaveClick() {
        val enteredName = nameInput.get()?.trim() ?: ""
        if (enteredName.isNotEmpty()) {
            names.add(enteredName)
            nameInput.set("")
        }
    }

    fun getFormattedNames(): String {
        return names.joinToString("\n")
    }
}
