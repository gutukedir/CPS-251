
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonCalculate.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val amountStr = binding.editTextAmount.text.toString()

        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Please enter a bill amount", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = amountStr.toDouble()

        val tip10 = amount * 0.1
        val tip15 = amount * 0.15
        val tip20 = amount * 0.2

        val result = "10% Tip: $tip10\n15% Tip: $tip15\n20% Tip: $tip20"

        binding.textViewResult.text = result
    }
}
