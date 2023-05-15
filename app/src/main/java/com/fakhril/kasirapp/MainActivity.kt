package com.fakhril.kasirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fakhril.kasirapp.databinding.ActivityMainBinding
import com.fakhril.kasirapp.meja.DataMeja
import com.fakhril.kasirapp.menu.DataMenu
import com.fakhril.kasirapp.user.DataUser

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.mainIvBgMenu.setOnClickListener{
            startActivity(Intent(this, DataMenu::class.java))
        }

        binding.mainIvBgUser.setOnClickListener{
            startActivity(Intent(this, DataUser::class.java))
        }

        binding.mainIvBgMeja.setOnClickListener {
            startActivity(Intent(this, DataMeja::class.java))
        }

    }

}