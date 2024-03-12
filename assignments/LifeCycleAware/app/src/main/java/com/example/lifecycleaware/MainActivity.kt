import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.lifecycleaware.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var observer: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        observer = MyObserver()
        lifecycle.addObserver(observer)

        viewModel.getEventsLiveData().observe(this, Observer { events ->
            for (event in events) {
                Log.d("ViewModelEvents", "Event: $event")
            }
        })

        viewModel.addEvent("onCreate")
    }
}
