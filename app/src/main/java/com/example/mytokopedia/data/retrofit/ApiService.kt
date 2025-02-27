package com.example.mytokopedia.data.retrofit

import ReadProfileResponse
import com.example.mytokopedia.data.response.ReadDiskonResponse
import com.example.mytokopedia.data.response.ReadMenuResponse
import com.example.mytokopedia.data.response.ReadProdukResponse
import com.example.mytokopedia.data.response.ReadTransaksiResponse
import com.example.mytokopedia.data.response.ReadUpdateResponse
import com.example.mytokopedia.data.response.ReadUserResponse
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("v1/produk")
    fun getAllForProduk() :Call<ReadProdukResponse>

    @GET("v1/produk")
    fun getAllMallProduk() :Call<ReadProdukResponse>

    @GET("v1/produk")
    fun getAllElektronikProduk() :Call<ReadProdukResponse>

    @GET("v1/produk")
    fun getAllDekatProduk() :Call<ReadProdukResponse>

    @GET("v1/produk")
    fun getAllMiripProduk() :Call<ReadProdukResponse>
//  Menampilkan History Transaksi
    @GET("v1/histori")  // Ganti dengan endpoint yang sesuai
    fun getTransaksiData(): Call<ReadTransaksiResponse>
//  Menampilkan Menu Lainya
    @GET("v1/menu")
    fun getMenuData(): Call<ReadMenuResponse>
//  Menampilkan Data User
    @GET("v1/user")
    fun getUserData(): Call<ReadUserResponse>  // Ganti dengan endpoint yang sesuai
//  Mengupdate Data User
    @FormUrlEncoded
    @PUT("v1/user/update/1")
    fun updateUser(
        @Field("nama") nama: String,
        @Field("username") username: String,
        @Field("bio") bio: String,
        @Field("email") email: String,
        @Field("nomor_hp") nomorHp: String,
        @Field("jenis_kelamin") jenisKelamin: String,
        @Field("tanggal_lahir") tanggalLahir: String,
        ): Call<ReadUpdateResponse>
//  Menampilkan produk diskon
    @GET("v1/diskon")
    fun getAllDiskon(): Call<ReadDiskonResponse>

// MenampilkanProfile
    @GET("v1/profil")
    fun getProfileData(): Call<ReadProfileResponse>
//
//    @DELETE("v1/profil/delete/1")
//    fun deleteProfilePhoto(
//        @Path("id") userId: Int
//    ): Call<DeleteProfileResponse>
//
//    @FormUrlEncoded
//    @PUT("v1/profil/update/2")
//    fun updateProfilePhoto(
//        @Path("id") userId: Int,
//        @Field("foto") photo: String
//    ): Call<UpdateProfileResponse>
//
//    @POST("v1/profil/create")
//    fun createProfilePhoto(
//        @Path("id") userId: Int,
//        @Field("foto") photo: String
//    ): Call<CreateProfileResponse>

}