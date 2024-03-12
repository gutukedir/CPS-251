import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyViewModel : ViewModel() {

    private val eventData = mutableListOf<String>()
    private val eventsLiveData = MutableLiveData<List<String>>()

    fun addEvent(event: String) {
        eventData.add(event)
        eventsLiveData.value = eventData.toList()
    }

    fun getEventsLiveData(): LiveData<List<String>> {
        return eventsLiveData
    }
}
