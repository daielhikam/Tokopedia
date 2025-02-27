package com.example.mytokopedia.bottomNavigation.transaksi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mytokopedia.R
import com.example.mytokopedia.data.response.DataTransaksi
import com.example.mytokopedia.databinding.ActivityDetailtransaksiBinding

class Detailtransaksi5 : AppCompatActivity() {
    private lateinit var binding : ActivityDetailtransaksiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailtransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menerima data yang dikirim dari ItemAdapter5
        val transaksi: DataTransaksi? = intent.getParcelableExtra("DATA_TRANSAKSI")

        // Menampilkan data ke UI (contohnya ke TextView)
        transaksi?.let {
            (binding.tvNamaProduk).text = it.namaProduk
            (binding.tvHarga).text = "Rp. ${String.format("%,d", it.harga)}"
            (binding.tvTanggal).text = it.tanggal
            // Set gambar produk (misalnya menggunakan Glide)
            Glide.with(this).load(it.photoProduk).into(binding.imgProduk)
            binding.imgPanah.setOnClickListener {
                onBackPressed() // Kembali ke activity sebelumnya
            }
        }
    }
}