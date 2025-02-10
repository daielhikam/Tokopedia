package com.example.mytokopedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytokopedia.databinding.ActivityDetailAdapter4Binding

class DetailRecycler4 : AppCompatActivity() {
    private lateinit var binding: ActivityDetailAdapter4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAdapter4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val imageRes = intent.getIntExtra("imageRes", 0) // Default 0 jika tidak ada
        val namaProduk = intent.getStringExtra("namaProduk")
        val harga = intent.getStringExtra("harga")
        val hargaAsli = intent.getStringExtra("hargaAsli")
        val rating = intent.getStringExtra("rating")
        val stok = intent.getStringExtra("stok")
        val gratisOngkir = intent.getBooleanExtra("gratisOngkir", false)
        val cod = intent.getBooleanExtra("cod", false)

        // Set data ke tampilan
        if (imageRes != 0) {
            binding.imgDetail.setImageResource(imageRes) // Pastikan id ImageView di XML benar
        }
        binding.tvDetailNamaProduk.text = namaProduk
        binding.tvDetailHarga.text = harga

        if (!hargaAsli.isNullOrEmpty()) {
            binding.tvDetailHargaAsli.text = hargaAsli
            binding.tvDetailHargaAsli.paintFlags = binding.tvDetailHargaAsli.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            binding.tvDetailHargaAsli.visibility = android.view.View.GONE
        }

        binding.tvDetailRating.text = rating
        binding.tvDetailStok.text = "Stok: $stok"

        binding.tvDetailGratisOngkir.visibility = if (gratisOngkir) android.view.View.VISIBLE else android.view.View.GONE
        binding.tvDetailCOD.visibility = if (cod) android.view.View.VISIBLE else android.view.View.GONE
    }
}