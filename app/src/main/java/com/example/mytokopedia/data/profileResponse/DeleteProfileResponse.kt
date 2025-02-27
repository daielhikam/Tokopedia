import com.google.gson.annotations.SerializedName

data class CreateDeleteProfile(

    @field:SerializedName("data")
    val data: List<DataDeleteProfile>,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int
)

data class DataDeleteProfile(

    @field:SerializedName("foto_profil")
    val fotoProfil: String,

    @field:SerializedName("id")
    val id: Int
)
