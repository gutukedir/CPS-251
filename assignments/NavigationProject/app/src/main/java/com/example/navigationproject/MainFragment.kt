import android.os.Bun   dle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayButton1.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToImageFragment(R.drawable.android_image_1)
            findNavController().navigate(action)
        }

        displayButton2.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToImageFragment(R.drawable.android_image_2)
            findNavController().navigate(action)
        }

        displayButton3.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToImageFragment(R.drawable.android_image_3)
            findNavController().navigate(action)
        }
    }
}
