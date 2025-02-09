package com.example.mytokopedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mytokopedia.databinding.ActivityDetailAdapter4Binding
import com.example.mytokopedia.databinding.ActivityMainBinding

class DetailAdapter4 : AppCompatActivity() {
    private lateinit var binding: ActivityDetailAdapter4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailAdapter4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
