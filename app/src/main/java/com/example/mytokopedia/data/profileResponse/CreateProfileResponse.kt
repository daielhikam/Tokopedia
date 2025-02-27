import com.google.gson.annotations.SerializedName

data class CreateUserProfile(

    @field:SerializedName("data")
    val data: List<DataCreateProfile>,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int
)

data class DataCreateProfile(

    @field:SerializedName("foto_profil")
    val fotoProfil: String,

    @field:SerializedName("id")
    val id: Int
)
