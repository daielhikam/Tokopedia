package com.example.mytokopedia.data.response

import com.google.gson.annotations.SerializedName

data class ReadProdukResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class DataItem(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("nama_produk")
	val namaProduk: String,

	@field:SerializedName("text_cod")
	val textCod: String,

	@field:SerializedName("harga_awal")
	val hargaAwal: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("harga_sekarang")
	val hargaSekarang: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("foto_produk")
	val fotoProduk: String,

	@field:SerializedName("text_gratis_ongkir")
	val textGratisOngkir: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
