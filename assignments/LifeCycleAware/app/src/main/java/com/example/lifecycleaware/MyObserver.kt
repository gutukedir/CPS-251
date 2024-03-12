import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import android.util.Log

class MyObserver : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        logEvent("onCreate")
    }

    override fun onResume(owner: LifecycleOwner) {
        logEvent("onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        logEvent("onPause")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        logEvent("onDestroy")
    }

    private fun logEvent(eventName: String) {
        val currentTime = System.currentTimeMillis()
        Log.d("LifecycleEvents", "$eventName at $currentTime ms")
    }
}
