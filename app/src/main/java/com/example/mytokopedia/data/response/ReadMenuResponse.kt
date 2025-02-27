package com.example.mytokopedia.data.response

import com.google.gson.annotations.SerializedName

data class ReadMenuResponse(

	@field:SerializedName("data")
	val data: List<DataItemMenu>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class DataItemMenu(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("nama_menu")
	val namaMenu: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("gambar_menu")
	val gambarMenu: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
