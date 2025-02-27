package com.example.mytokopedia.data.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ReadTransaksiResponse(

	@field:SerializedName("data")
	val data: List<DataTransaksi>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class DataTransaksi(

	@field:SerializedName("createdAt")
	val createdAt: String?,

	@field:SerializedName("nama_produk")
	val namaProduk: String?,

	@field:SerializedName("harga")
	val harga: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("tanggal")
	val tanggal: String?,

	@field:SerializedName("photo_produk")
	val photoProduk: String?,

	@field:SerializedName("updatedAt")
	val updatedAt: String?
): Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readInt(),
		parcel.readInt(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(createdAt)
		parcel.writeString(namaProduk)
		parcel.writeInt(harga)
		parcel.writeInt(id)
		parcel.writeString(tanggal)
		parcel.writeString(photoProduk)
		parcel.writeString(updatedAt)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<DataTransaksi> {
		override fun createFromParcel(parcel: Parcel): DataTransaksi {
			return DataTransaksi(parcel)
		}

		override fun newArray(size: Int): Array<DataTransaksi?> {
			return arrayOfNulls(size)
		}
	}
}
