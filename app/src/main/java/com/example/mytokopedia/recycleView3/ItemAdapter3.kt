package com.example.mytokopedia.recycleView3

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mytokopedia.R
import com.example.mytokopedia.databinding.ItemList3Binding

class ItemAdapter3(private val itemList: List<Item3>,
    private val onItemClick: (Item3) -> Unit) :
    RecyclerView.Adapter<ItemAdapter3.ViewHolder>() {

    class ViewHolder(val binding: ItemList3Binding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemList3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
                with(holder.binding) {
            imgProduk.setImageResource(item.image)
            txtHargaDiskon.text = "Rp${item.hargaDiskon}"
            txtHargaAsli.text = "Rp${item.hargaAsli}"





            // Menambahkan efek coret pada harga asli
            txtHargaAsli.paintFlags = txtHargaAsli.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

            // Set gambar diskon sesuai persentase
            imgDiskon.setImageResource(
                when (item.diskon) {
                    1 -> R.drawable.ic_diskon
                    2 -> R.drawable.ic_diskon
                    3 -> R.drawable.ic_diskon
                    4 -> R.drawable.ic_diskon
                    else -> R.drawable.ic_kupon // Default jika tidak ada diskon spesifik
                }
            )
                    imgProduk.setOnClickListener {
                        onItemClick(item)
                        Toast.makeText(root.context, "Item ${item.diskon} diklik", Toast.LENGTH_SHORT).show()
                    }
        }

    }

    override fun getItemCount(): Int = itemList.size
}
