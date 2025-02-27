package com.example.mytokopedia.tabLayoutHome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mytokopedia.R
import com.example.mytokopedia.adapter.ItemAdapter4
import com.example.mytokopedia.data.response.DataItem
import com.example.mytokopedia.data.response.ReadProdukResponse
import com.example.mytokopedia.data.retrofit.ApiConfig
import com.example.mytokopedia.databinding.FragmentDekatBinding
import com.example.mytokopedia.databinding.FragmentFormeBinding
import com.example.mytokopedia.databinding.FragmentMallBinding
import com.example.mytokopedia.recycleView4.Item4
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentDekat : Fragment() {
    companion object{
        val TAG = FragmentDekat::class.java.simpleName
        val DataItem: MutableList<DataItem> = mutableListOf()
    }
    private lateinit var binding: FragmentDekatBinding
    private val produkAdapter = ItemAdapter4(DataItem)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDekatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        binding.recyclerView4.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView4.adapter = produkAdapter

        fetchProduk()
    }

    private fun fetchProduk() {
        ApiConfig.getApiService().getAllDekatProduk().enqueue(object : Callback<ReadProdukResponse> {
            override fun onResponse(call: Call<ReadProdukResponse>, response: Response<ReadProdukResponse>) {
                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        DataItem.clear()
                        DataItem.addAll(it)
                        produkAdapter.notifyDataSetChanged()
                    }
                } else {
                    Log.e("API_ERROR", "Gagal mengambil data: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ReadProdukResponse>, t: Throwable) {
                Log.e("API_ERROR", "Error: ${t.message}")
            }
        })
    }
}