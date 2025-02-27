package com.example.mytokopedia.recycleViewTabTransaksi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytokopedia.bottomNavigation.transaksi.DetailTabTransaksi
import com.example.mytokopedia.databinding.ItemListSpinerDetailBinding
import com.example.mytokopedia.recycleView1.Item1

class AdapterTabTransaksi (val listTabTransaksi: List<Item1>) :
    RecyclerView.Adapter<AdapterTabTransaksi.ViewHolder>() {

        class ViewHolder(val binding: ItemListSpinerDetailBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListSpinerDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listTabTransaksi[position]
        holder.binding.itemText.text = item.name
        holder.binding.itemImage.setImageResource(item.image)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailTabTransaksi::class.java)
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount() = listTabTransaksi.size

    }


