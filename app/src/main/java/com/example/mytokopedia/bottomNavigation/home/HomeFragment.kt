package com.example.mytokopedia.bottomNavigation.home

import ItemAdapter1
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytokopedia.R
import com.example.mytokopedia.data.response.DataItemMenu
import com.example.mytokopedia.data.response.DataItemDiskon
import com.example.mytokopedia.data.response.ReadDiskonResponse
import com.example.mytokopedia.data.response.ReadMenuResponse
import com.example.mytokopedia.data.retrofit.ApiConfig
import com.example.mytokopedia.tabLayoutHome.ViewPagerAdapter
import com.example.mytokopedia.databinding.FragmentHomeBinding
import com.example.mytokopedia.recycleView1.Item1
import com.example.mytokopedia.recycleView2.Item2
import com.example.mytokopedia.recycleView2.ItemAdapter2
import com.example.mytokopedia.recycleView3.ItemAdapter3
import com.example.mytokopedia.recycleView3.Item3
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    companion object{
        val DataMenu : MutableList<DataItemMenu> = mutableListOf()
    }

    private lateinit var menuAdapter: ItemAdapter2
    private lateinit var itemAdapter3: ItemAdapter3
    private val itemList: MutableList<DataItemDiskon> = mutableListOf() // Data diskon untuk RecyclerView3

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Setup RecyclerView untuk Flash Sale (RecyclerView3) dengan data dari API
        itemAdapter3 = ItemAdapter3(itemList) { selectedItem ->
            findNavController().navigate(R.id.action_navigation_home_to_fragmentFlash)
            Toast.makeText(requireContext(), "Flash Sale: ${selectedItem.hargaDiskon}", Toast.LENGTH_SHORT).show()
        }

        binding.recyclerViewFlashSale.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = itemAdapter3
        }

        // Setup RecyclerView 1 (Data statis)
        val itemList1 = listOf(
            Item1(R.drawable.ic_gopay, "Rp.0"),
            Item1(R.drawable.ic_kupon, "Cek Kupon"),
            Item1(R.drawable.ic_lok, "Di Kirim Ke Rumah Dai El Hikam")
        )
        binding.recyclerView1.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView1.adapter = ItemAdapter1(itemList1)

        // Setup RecyclerView 2 (Data dari API)
        menuAdapter = ItemAdapter2(DataMenu)
        binding.recyclerView2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView2.adapter = menuAdapter

        fetchMenuData() // Mengambil data menu dari API
        fetchDiskonData() // Mengambil data diskon dari API untuk RecyclerView3

        // MULAI COUNTDOWN TIMER (Hitung Mundur)
        startFlashSaleCountdown()

        return root
    }

    // Fungsi untuk mengambil data menu dari API
    private fun fetchMenuData() {
        ApiConfig.getApiService().getMenuData().enqueue(object : Callback<ReadMenuResponse> {
            override fun onResponse(call: Call<ReadMenuResponse>, response: Response<ReadMenuResponse>) {
                if (response.isSuccessful) {
                    val menuItems = response.body()?.data
                    if (!menuItems.isNullOrEmpty()) {
                        DataMenu.clear()
                        DataMenu.addAll(menuItems)
                        menuAdapter.notifyDataSetChanged() // Update RecyclerView
                    }
                } else {
                    Log.e("HomeFragment", "Response gagal: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ReadMenuResponse>, t: Throwable) {
                Log.e("HomeFragment", "Error fetching menu: ${t.message}")
            }
        })
    }

    // Fungsi untuk mengambil data diskon untuk RecyclerView3
    private fun fetchDiskonData() {
        ApiConfig.getApiService().getAllDiskon().enqueue(object : Callback<ReadDiskonResponse> {
            override fun onResponse(
                call: Call<ReadDiskonResponse>,
                response: Response<ReadDiskonResponse>
            ) {
                if (response.isSuccessful) {
                    val diskonItems = response.body()?.data ?: emptyList()
                    itemList.clear()
                    itemList.addAll(diskonItems)
                    itemAdapter3.notifyDataSetChanged() // Update RecyclerView3
                } else {
                    Log.e("HomeFragment", "Response gagal: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ReadDiskonResponse>, t: Throwable) {
                Log.e("HomeFragment", "Error fetching diskon data: ${t.message}")
            }
        })
    }

    // Fungsi untuk menghitung mundur flash sale
    private fun startFlashSaleCountdown() {
        val timerTextView = binding.tvFlashSaleTimer

        val flashSaleTimeMillis = 3L * 60 * 60 * 1000 // 3 Jam dalam Milliseconds

        object : CountDownTimer(flashSaleTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60
                val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                timerTextView.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
            }

            override fun onFinish() {
                timerTextView.text = "00:00:00"
            }
        }.start()

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        // Menambahkan viewPager
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}