// com.example.savedataproject2.MainActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.savedataproject2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var namesViewModel: NamesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        namesViewModel = if (savedInstanceState == null) {
            NamesViewModel()
        } else {
            val savedViewModel = lastCustomNonConfigurationInstance as NamesViewModel?
            savedViewModel ?: NamesViewModel()
        }

        binding.viewModel = namesViewModel
        binding.lifecycleOwner = this
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return namesViewModel
    }
}
