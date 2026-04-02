package com.agartha.agartha

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fragmentWelcome = welcome()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, fragmentWelcome)
            .commit()
        val btnMulai = findViewById<Button>(R.id.button)
        btnMulai.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, welcome())
                .addToBackStack(null) // Tambahkan ini agar saat klik tombol back tidak langsung keluar aplikasi
                .commit()
        }
    }
}