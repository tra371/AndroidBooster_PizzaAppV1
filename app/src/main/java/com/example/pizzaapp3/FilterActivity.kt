package com.example.pizzaapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.pizzaapp3.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCloseFilter.setOnClickListener{
            super.finish()
        }

    }
}