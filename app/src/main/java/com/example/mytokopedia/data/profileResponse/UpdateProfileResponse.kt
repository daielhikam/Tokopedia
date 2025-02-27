package com.example.mytokopedia.data.profileResponse

import com.google.gson.annotations.SerializedName

data class updateProfileResponse(

    @field:SerializedName("data")
    val data: List<DataUpdateProfile>,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Int
)

data class DataUpdateProfile(

    @field:SerializedName("foto_profil")
    val fotoProfil: String,

    @field:SerializedName("id")
    val id: Int
)
