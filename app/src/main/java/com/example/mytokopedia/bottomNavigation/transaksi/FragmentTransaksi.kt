package com.example.mytokopedia.bottomNavigation.transaksi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytokopedia.R
import com.example.mytokopedia.data.response.DataTransaksi
import com.example.mytokopedia.data.response.ReadTransaksiResponse
import com.example.mytokopedia.data.retrofit.ApiConfig
import com.example.mytokopedia.databinding.FragmentTransaksiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        // Ambil data transaksi dari API
        getTransaksiData()
    }

    private fun getTransaksiData() {
        // Memanggil API
        ApiConfig.getApiService().getTransaksiData().enqueue(object : Callback<ReadTransaksiResponse> {
            override fun onResponse(
                call: Call<ReadTransaksiResponse>,
                response: Response<ReadTransaksiResponse>
            ) {
                if (response.isSuccessful) {
                    val transaksiList = response.body()?.data ?: emptyList()
                    // Panggil adapter dan set data ke RecyclerView
                    setupRecyclerView(transaksiList)
                } else {
                    Toast.makeText(requireContext(), "Gagal mendapatkan data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ReadTransaksiResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView(transaksiList: List<DataTransaksi>) {
        // Set adapter ke RecyclerView
        val adapter = ItemAdapter5(transaksiList,
            onSelesaiClick = { item ->
                Toast.makeText(requireContext(), "Transaksi Selesai: ${item.namaProduk}", Toast.LENGTH_SHORT).show()
            },
            onBeliLagiClick = { item ->
                // Aksi ketika tombol "Beli Lagi" diklik
            }
        )
        binding.rvTransaksi.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTransaksi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}