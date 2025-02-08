package com.example.mytokopedia.ui.home

import ItemAdapter1
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytokopedia.R
import com.example.mytokopedia.databinding.FragmentHomeBinding
import com.example.mytokopedia.recycleView1.Item1
import com.example.mytokopedia.recycleView2.Item2
import com.example.mytokopedia.recycleView2.ItemAdapter2
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

        // Dummy Data untuk RecyclerView 1
        val itemList1 = listOf(
            Item1(R.drawable.ic_gopay, "Rp.0"),
            Item1(R.drawable.ic_kupon, "Cek Kupon"),
            Item1(R.drawable.ic_lok, "Di Kirim Ke Rumah Dai El Hikam")
        )

        // Dummy Data untuk RecyclerView 2 (Item Bulat)
        val itemList2 = listOf(
            Item2(R.drawable.ic_keranjang, "Keranjang"),
            Item2(R.drawable.ic_kupon, "Voucher"),
            Item2(R.drawable.ic_lok, "Lokasi"),
            Item2(R.drawable.ic_keranjang, "Keranjang"),
            Item2(R.drawable.ic_kupon, "Voucher"),
            Item2(R.drawable.ic_lok, "Lokasi"), Item2(R.drawable.ic_keranjang, "Keranjang"),
            Item2(R.drawable.ic_kupon, "Voucher"),
            Item2(R.drawable.ic_lok, "Lokasi"),
            Item2(R.drawable.ic_gopay, "Saldo")
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}