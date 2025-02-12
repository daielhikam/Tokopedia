package com.example.mytokopedia.bottomNavigation.transaksi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytokopedia.R
import com.example.mytokopedia.databinding.FragmentTransaksiBinding
import com.example.mytokopedia.recycleView1.Item1
import com.example.mytokopedia.recycleViewTabTransaksi.AdapterTabTransaksi

class FragmentTransaksi : Fragment() {
    private var _binding: FragmentTransaksiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransaksiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemTabList = listOf(
            Item1(R.drawable.ic_panahbawah, "Semua Status"),
            Item1(R.drawable.ic_panahbawah, "Semua Produk"),
            Item1(R.drawable.ic_panahbawah, "Semua Transaksi"),
        )

        val transaksiList = listOf(
            Item5(R.drawable.image_kasur, "Kasur Lipat Portable", "Rp 35.500", "13 Oktoner 2022"),
            Item5(R.drawable.image_baju, "Kaos Polos Premium", "Rp 75.000", "18 November 2023"),
            Item5(R.drawable.image_topi, "Topi Baseball Original", "Rp 15.000", "15 Januari 2024"),
            Item5(R.drawable.image_hp, "Smartphone Samsung A14", "Rp 20.999", "12 Februari 20224"),
            Item5(R.drawable.image_celana, "Celana Jeans Slim Fit", "Rp 199.000", "1 Juni 2025"),
            Item5(R.drawable.image_baju, "Hoodie Oversize Hitam", "Rp 250.000", "10 Mei 2025"),
            Item5(R.drawable.image_jaket, "Jaket Bomber Pria", "Rp 300.000", "11 April 2025"),
            Item5(R.drawable.image_lampu, "Lampu LED Hemat Energi", "Rp 45.000", "15 Maret 2026"),
            Item5(R.drawable.image_bajuu, "Kemeja Flanel Kotak", "Rp 180.000", "14 Desember 2027"),
            Item5(R.drawable.image_sepatu, "Sepatu Sneakers Adidas", "Rp 100.000", "12 Nov 2028")
        )

        val adapter1 = AdapterTabTransaksi(itemTabList)
        binding.rvtablayoutTransaksi.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvtablayoutTransaksi.adapter = adapter1


        val adapter = ItemAdapter5(transaksiList)
        binding.rvTransaksi.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTransaksi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}