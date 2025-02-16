package com.example.mytokopedia.recycleView4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytokopedia.databinding.ActivityDetailRecyclerview4Binding

class DetailRecycler4 : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRecyclerview4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecyclerview4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.panahdetail4.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Ambil data dari Intent
        val imageRes = intent.getIntExtra("imageRes", 0) // Default 0 jika tidak ada
        val namaProduk = intent.getStringExtra("namaProduk")
        val harga = intent.getStringExtra("harga")
        val gratisOngkir = intent.getBooleanExtra("gratisOngkir", false)

        // Set data ke tampilan
        if (imageRes != 0) {
            binding.imgDetail.setImageResource(imageRes) // Pastikan id ImageView di XML benar
        }
        binding.tvDetailNamaProduk.text = namaProduk
        binding.tvDetailHarga.text = harga


        binding.tvDetailGratisOngkir.visibility = if (gratisOngkir) android.view.View.VISIBLE else android.view.View.GONE

    }
}