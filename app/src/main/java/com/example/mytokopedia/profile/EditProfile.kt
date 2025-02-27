package com.example.mytokopedia.profile

import ProfileViewModel
import ReadProfileResponse
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mytokopedia.bottomNavigation.akun.FragmentAkun
import com.example.mytokopedia.data.response.ReadUpdateResponse
import com.example.mytokopedia.data.response.ReadUserResponse
import com.example.mytokopedia.data.retrofit.ApiConfig
import com.example.mytokopedia.databinding.ActivityEditProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfile : AppCompatActivity() {

    private lateinit var profileViewModel: ProfileViewModel

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Inisialisasi ViewModel

        binding.back.setOnClickListener {
            onBackPressed() // Kembali ke halaman sebelumnya
        }

        getProfile()
        // Menarik data pengguna untuk di-edit
        fetchUserData()

        // Tombol save untuk memperbarui data pengguna
        binding.btnSave.setOnClickListener {
            updateUserData()
        }
    }

    private fun getProfile() {
        ApiConfig.getApiService().getProfileData().enqueue(object : Callback<ReadProfileResponse> {
            override fun onResponse(
                call: Call<ReadProfileResponse>,
                response: Response<ReadProfileResponse>
            ) {
                if (response.isSuccessful) {
                    val profile = response.body()?.data?.get(0) // Ambil data pertama dari array 'data'
                    if (profile != null) {
                        val imageUrl = profile.fotoProfil
                        if (!imageUrl.isNullOrEmpty()) {

                            Glide.with(binding.potoProfile.context)
                                .load(imageUrl)
                                .into(binding.potoProfile) // Set gambar di EditProfileActivity
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ReadProfileResponse>, t: Throwable) {
                Log.e("EditProfileActivity", "Error: ${t.message}")
            }
        })
    }

    private fun fetchUserData() {
        // Panggil API untuk mengambil data pengguna (jika diperlukan)
        ApiConfig.getApiService().getUserData().enqueue(object : Callback<ReadUserResponse> {
            override fun onResponse(
                call: Call<ReadUserResponse>,
                response: Response<ReadUserResponse>
            ) {
                if (response.isSuccessful) {
                    val userList = response.body()?.data
                    if (!userList.isNullOrEmpty()) {
                        val firstUser = userList[0] // Ambil user pertama

                        // Isi data pengguna ke form
                        binding.edtNama.setText(firstUser.nama)
                        binding.edtUsername.setText(firstUser.username)
                        binding.edtBio.setText(firstUser.bio)
                        binding.edtEmail.setText(firstUser.email)
                        binding.edtNohp.setText(firstUser.nomorHp)
                        binding.edtJenisKelamin.setText(firstUser.jenisKelamin)
                        binding.edtTglLahir.setText(firstUser.tanggalLahir)
                    } else {
                        Log.e("EditProfileActivity", "Data user kosong")
                    }
                } else {
                    Log.e("EditProfileActivity", "Response gagal: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ReadUserResponse>, t: Throwable) {
                Log.e("EditProfileActivity", "Error: ${t.message}")
            }
        })
    }

    private fun updateUserData() {
        // Ambil data yang sudah dimasukkan oleh pengguna
        val nama = binding.edtNama.text.toString()
        val username = binding.edtUsername.text.toString()
        val bio = binding.edtBio.text.toString()
        val email = binding.edtEmail.text.toString()
        val nomorHp = binding.edtNohp.text.toString()
        val jenisKelamin = binding.edtJenisKelamin.text.toString()
        val tanggalLahir = binding.edtTglLahir.text.toString()

        // Panggil API untuk mengupdate data pengguna
        ApiConfig.getApiService().updateUser(nama, username, bio, email, nomorHp, jenisKelamin, tanggalLahir).enqueue(object : Callback<ReadUpdateResponse> {
            override fun onResponse(call: Call<ReadUpdateResponse>, response: Response<ReadUpdateResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@EditProfile, "Terjadi kesalahan jaringan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@EditProfile, "Gagal memperbarui data", Toast.LENGTH_SHORT).show()
                    Log.e("EditProfile", "Gagal update: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ReadUpdateResponse>, t: Throwable) {
                Log.e("EditProfileActivity", "Error: ${t.message}")
                Toast.makeText(this@EditProfile, "Data berhasil diperbarui!", Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }
}

