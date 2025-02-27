package com.example.mytokopedia.data.response

import com.google.gson.annotations.SerializedName

data class ReadUpdateResponse(

    @field:SerializedName("data")
    val data: List<DataUpdateUser>,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int
)

data class DataUpdateUser(

    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("bio")
    val bio: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("jenis_kelamin")
    val jenisKelamin: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("nomor_hp")
    val nomorHp: String,

    @field:SerializedName("tanggal_lahir")
    val tanggalLahir: String,

    @field:SerializedName("username")
    val username: String,

    @field:SerializedName("updatedAt")
    val updatedAt: String
)
