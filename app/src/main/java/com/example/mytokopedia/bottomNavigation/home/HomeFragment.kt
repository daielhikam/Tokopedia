package com.example.mytokopedia.bottomNavigation.home

import ItemAdapter1
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytokopedia.R
import com.example.mytokopedia.tabLayoutHome.ViewPagerAdapter
import com.example.mytokopedia.databinding.FragmentHomeBinding
import com.example.mytokopedia.recycleView1.Item1
import com.example.mytokopedia.recycleView2.Item2
import com.example.mytokopedia.recycleView2.ItemAdapter2
import com.example.mytokopedia.recycleView3.Item3
import com.example.mytokopedia.recycleView3.ItemAdapter3
import com.google.android.material.tabs.TabLayoutMediator
import java.util.concurrent.TimeUnit

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //adapter3
        val itemList = listOf(
            Item3(R.drawable.image_lampu, 1, "48.490", "72.690"),
            Item3(R.drawable.image_baju, 2, "99.900", "125.000"),
            Item3(R.drawable.image_sepatu, 3, "150.000", "200.000"),
            Item3(R.drawable.image_kasur, 4, "25.000", "50.000")
        )
        val itemAdapter = ItemAdapter3(itemList) { selectedItem ->
            findNavController().navigate(R.id.action_navigation_home_to_fragmentFlash)
            Toast.makeText(requireContext(), "Flash Sale: ${selectedItem.hargaDiskon}", Toast.LENGTH_SHORT).show()
        }

        binding.recyclerViewFlashSale.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = itemAdapter
        }

        // Data untuk RecyclerView 1
        val itemList1 = listOf(
            Item1(R.drawable.ic_gopay, "Rp.0"),
            Item1(R.drawable.ic_kupon, "Cek Kupon"),
            Item1(R.drawable.ic_lok, "Di Kirim Ke Rumah Dai El Hikam")
        )

        // Data untuk RecyclerView 2 (Item Bulat)
        val itemList2 = listOf(
            Item2(R.drawable.image_seru, "Promo Ramadhan"),
            Item2(R.drawable.image_topup, "Top Up $ Tagihan"),
            Item2(R.drawable.image_cicil, "Cicil Tanpa Biaya"),
            Item2(R.drawable.image_pesawat, "Tiket & Hiburan"),
            Item2(R.drawable.ic_promohariini, "Promo Hari Ini"),
            Item2(R.drawable.image_live, "Live Shopping"),
            Item2(R.drawable.ic_gopay, "Gopay Later"),
            Item2(R.drawable.image_jaket, "Jaket"),
            Item2(R.drawable.image_sepatu, "sepatu"),
            Item2(R.drawable.ic_keranjang, "Keranjang"),
            Item2(R.drawable.image_hp, "Iphone")
        )

        // Setup RecyclerView 1
        binding.recyclerView1.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView1.adapter = ItemAdapter1(itemList1)

        // Setup RecyclerView 2 (Horizontal)
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView2.adapter = ItemAdapter2(itemList2)


        // MULAI COUNTDOWN TIMER (Hitung Mundur)
        startFlashSaleCountdown()

        return root
    }

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

        //menambahkan viewPager
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}