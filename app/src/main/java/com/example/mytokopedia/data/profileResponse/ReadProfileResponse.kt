import com.google.gson.annotations.SerializedName

data class ReadProfileResponse(

	@field:SerializedName("data")
	val data: List<DataItemProfile>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class DataItemProfile(

	@field:SerializedName("foto_profil")
	val fotoProfil: String,

	@field:SerializedName("id")
	val id: Int
)
