package com.example.mytokopedia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytokopedia.R
import com.example.mytokopedia.TransaksiAdapter
import com.example.mytokopedia.TransaksiItem
import com.example.mytokopedia.databinding.FragmentTransaksiBinding

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

        val transaksiList = listOf(
            TransaksiItem(R.drawable.image_kasur, "Kasur Lipat Portable", "Rp 35.500", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_baju, "Kaos Polos Premium", "Rp 75.000", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_topi, "Topi Baseball Original", "Rp 15.000", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_hp, "Smartphone Samsung A14", "Rp 20.999", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_celana, "Celana Jeans Slim Fit", "Rp 199.000", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_baju, "Hoodie Oversize Hitam", "Rp 250.000", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_jaket, "Jaket Bomber Pria", "Rp 300.000", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_lampu, "Lampu LED Hemat Energi", "Rp 45.000", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_bajuu, "Kemeja Flanel Kotak", "Rp 180.000", "13 Nov 2023"),
            TransaksiItem(R.drawable.image_sepatu, "Sepatu Sneakers Adidas", "Rp 100.000", "13 Nov 2023")
        )


        val adapter = TransaksiAdapter(transaksiList)
        binding.rvTransaksi.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTransaksi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}