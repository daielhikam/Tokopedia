package com.example.mytokopedia.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytokopedia.data.retrofit.ApiConfig
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _profilePicture = MutableLiveData<String>()
    val profilePicture: LiveData<String> get() = _profilePicture

    fun fetchProfile() {
        viewModelScope.launch {
            try {
                val response = ApiConfig.getApiService().getProfileData().execute() // Pastikan ini memanggil API dengan benar
                if (response.isSuccessful) {
                    val profileData = response.body()?.data
                    if (!profileData.isNullOrEmpty()) {
                        _profilePicture.postValue(profileData[0].fotoProfil) // Ambil URL foto profil
                    } else {
                        Log.e("ProfileViewModel", "Data profile kosong")
                    }
                } else {
                    Log.e("ProfileViewModel", "Gagal mengambil data profile: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Error fetching profile: ${e.message}")
            }
        }
    }
}