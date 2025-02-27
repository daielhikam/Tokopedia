package com.example.mytokopedia.recycleView3

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytokopedia.R
import com.example.mytokopedia.data.response.DataItemDiskon
import com.example.mytokopedia.databinding.ItemList3Binding

class ItemAdapter3(
    private val itemList: List<DataItemDiskon>,
    private val onItemClick: (DataItemDiskon) -> Unit
) : RecyclerView.Adapter<ItemAdapter3.ViewHolder>() {

    class ViewHolder(val binding: ItemList3Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemList3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        // Menggunakan Glide untuk menampilkan gambar
        Glide.with(holder.binding.imgProduk.context)
            .load(item.gambarProduk)  // Sesuaikan dengan data gambar produk
            .into(holder.binding.imgProduk)

        // Menampilkan harga asli dengan coret
        holder.binding.txtHargaAsli.text = "Rp ${item.hargaAsli}"
        holder.binding.txtHargaAsli.paintFlags = holder.binding.txtHargaAsli.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        // Menampilkan harga diskon
        holder.binding.txtHargaDiskon.text = "Rp ${item.hargaDiskon}"

        // Menangani klik item
        holder.binding.imgProduk.setOnClickListener {
            onItemClick(item)
            Toast.makeText(it.context, "Item ${item.gambarDiskon} diklik", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = itemList.size
}