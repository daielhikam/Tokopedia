package com.example.mytokopedia.bottomNavigation.transaksi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytokopedia.data.response.DataTransaksi
import com.example.mytokopedia.databinding.ItemTransaksiBinding

class ItemAdapter5(
    private val transaksiList: List<DataTransaksi>,
    private val onSelesaiClick: (DataTransaksi) -> Unit,
    private val onBeliLagiClick: (DataTransaksi) -> Unit
) : RecyclerView.Adapter<ItemAdapter5.TransaksiViewHolder>() {

    inner class TransaksiViewHolder(private val binding: ItemTransaksiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataTransaksi) {
            // Menampilkan tanggal
            binding.tvTanggal.text = item.tanggal

            // Menampilkan nama produk
            binding.tvNamaProduk.text = item.namaProduk

            // Menampilkan harga, format menjadi Rp (misalnya: Rp 35.500)
            binding.tvTotalBelanja.text = "Rp. ${String.format("%,d", item.harga)}"

            // Menampilkan gambar produk menggunakan Glide atau Picasso (jika photoProduk adalah URL)
            Glide.with(binding.root.context)
                .load(item.photoProduk)  // Menangani URL gambar
                .into(binding.imgProduk)  // Pastikan ada ImageView di layout

            // Klik tombol "Selesai"
            binding.btnSelesai.setOnClickListener {
                onSelesaiClick(item)
            }

            // Klik tombol "Beli Lagi"
            binding.btnBeliLagi.setOnClickListener {
                onBeliLagiClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
        val binding = ItemTransaksiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransaksiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {
        val transaksi = transaksiList[position]
        holder.bind(transaksi)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, Detailtransaksi5::class.java)
            intent.putExtra("DATA_TRANSAKSI", transaksi)  // Memasukkan data transaksi ke DetailTransaksiActivity
            holder.itemView.context.startActivity(intent)  // Membuka DetailTransaksiActivity ketika item dipilih
        }
    }

    override fun getItemCount(): Int = transaksiList.size
}