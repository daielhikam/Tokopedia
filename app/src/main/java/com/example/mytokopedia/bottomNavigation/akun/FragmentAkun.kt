package com.example.mytokopedia.bottomNavigation.akun

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytokopedia.R
import com.example.mytokopedia.bottomNavigation.transaksi.FragmentTransaksi
import com.example.mytokopedia.databinding.FragmentAkunBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class FragmentAkun : Fragment() {
    private lateinit var binding: FragmentAkunBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAkunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDaftarTransaksi.setOnClickListener {
            val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.nav_view)
            bottomNav?.selectedItemId = R.id.navigation_transaksi
        }
    }

}