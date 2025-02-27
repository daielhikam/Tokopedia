import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    // LiveData untuk imageUrl
    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String> get() = _imageUrl

    // Set imageUrl
    fun setImageUrl(url: String) {
        _imageUrl.value = url
    }
}
