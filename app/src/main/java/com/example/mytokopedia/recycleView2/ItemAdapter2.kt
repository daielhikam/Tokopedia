package com.example.mytokopedia.recycleView2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytokopedia.R
import com.example.mytokopedia.data.response.DataItemMenu

class ItemAdapter2(private val itemList: List<DataItemMenu>) :
    RecyclerView.Adapter<ItemAdapter2.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val textView: TextView = view.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list2, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        Glide.with(holder.imageView.context)
            .load(item.gambarMenu)
            .into(holder.imageView)
        holder.textView.text = item.namaMenu
    }

    override fun getItemCount() = itemList.size
}