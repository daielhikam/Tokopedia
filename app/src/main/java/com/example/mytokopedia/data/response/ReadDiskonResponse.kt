package com.example.mytokopedia.data.response

import com.google.gson.annotations.SerializedName

data class ReadDiskonResponse(

	@field:SerializedName("data")
	val data: List<DataItemDiskon>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class DataItemDiskon(

	@field:SerializedName("gambar_diskon")
	val gambarDiskon: String,

	@field:SerializedName("harga_asli")
	val hargaAsli: Int,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("harga_diskon")
	val hargaDiskon: Int,

	@field:SerializedName("gambar_produk")
	val gambarProduk: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
