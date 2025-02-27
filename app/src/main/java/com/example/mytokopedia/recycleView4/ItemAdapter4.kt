package com.example.mytokopedia.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytokopedia.data.response.DataItem
import com.example.mytokopedia.databinding.ItemList4Binding

class ItemAdapter4(private val productList: List<DataItem>) :
    RecyclerView.Adapter<ItemAdapter4.ProductViewHolder>() {

    inner class ProductViewHolder(private val binding: ItemList4Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: DataItem) {
            // Load gambar dari URL menggunakan Glide
            Glide.with(binding.imgprodak.context)
                .load(product.fotoProduk)
                .into(binding.imgprodak)

            binding.tvRating.text = product.deskripsi
            binding.tvNamaProduk.text = product.namaProduk
            binding.tvHargaSekarang.text = "Rp${product.hargaSekarang}"

            if (!product.hargaAwal.isNullOrEmpty()) {
                binding.tvHargaAwal.visibility = View.VISIBLE
                binding.tvHargaAwal.text = "Rp${product.hargaAwal}"
                binding.tvHargaAwal.paintFlags = binding.tvHargaAwal.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                binding.tvHargaAwal.visibility = View.GONE
            }

            // Menampilkan Gratis Ongkir jika ada
            binding.tvGratisOngkir.visibility = if (product.textGratisOngkir == "gratis ongkir") View.VISIBLE else View.GONE

            // Menampilkan COD jika ada
            binding.tvCOD.visibility = if (product.textCod == "COD") View.VISIBLE else View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemList4Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productList.size
}