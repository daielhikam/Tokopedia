package com.example.mytokopedia

import ItemAdapter1
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytokopedia.databinding.ActivityMainBinding
import com.example.mytokopedia.recycleView1.Item1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_promo, R.id.navigation_mall, R.id.navigation_transaksi, R.id.navigation_akun
            )
        )
        navView.setupWithNavController(navController)
// Reset fragment ke halaman utama saat berpindah tab
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.popBackStack(R.id.navigation_home, false)
                }
                R.id.navigation_promo -> {
                    navController.popBackStack(R.id.navigation_promo, false)
                }
                R.id.navigation_mall -> {
                    navController.popBackStack(R.id.navigation_mall, false)
                }
                R.id.navigation_transaksi -> {
                    navController.popBackStack(R.id.navigation_transaksi, false)
                }
                R.id.navigation_akun -> {
                    navController.popBackStack(R.id.navigation_akun, false)
                }
            }
            navController.navigate(item.itemId)
            true
        }
    }
}