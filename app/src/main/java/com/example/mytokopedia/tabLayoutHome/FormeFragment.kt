package com.example.mytokopedia.tabLayoutHome

import ItemAdapter4
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytokopedia.R
import com.example.mytokopedia.databinding.FragmentElektronikBinding
import com.example.mytokopedia.databinding.FragmentFormeBinding
import com.example.mytokopedia.recycleView4.Item4


class FormeFragment : Fragment() {
    private lateinit var binding: FragmentFormeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFormeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data untuk RecyclerView di FormeFragment
        val itemList4 = listOf(
            Item4(R.drawable.image_sepatu,  "Sepatu", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_kasur,  "Kasur", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_jaket,  "Jaket", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_topi,  "Topi", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_hp, "IPhone", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_celana,  "Kasur", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_kasur,  "Kasur", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_sepatu,  "Sepatu", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_baju,  "Baju", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_jaket,  "Jaket", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_hp,  "IPhone", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_baju, "Baju", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_celana,  "Celana", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_hp,  "IPhone", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_topi,  "Topi", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_jaket,  "Jaket", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_bajuu, "Baju Pria", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_lampu,  "Lampu", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_baju,  "Baju", "Rp50.000", "Rp40.000", "4.8", "50rb+", true, true),
            Item4(R.drawable.image_baju,  "Baju Fashion", "Rp120.000", "Rp100.000", "4.7", "20rb+", true, false)
        )

        // Setup RecyclerView
        binding.recyclerView4.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerView4.adapter = ItemAdapter4(itemList4)
    }
}