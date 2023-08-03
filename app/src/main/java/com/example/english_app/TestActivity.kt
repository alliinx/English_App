package com.example.english_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.english_app.databinding.ActivityTestBinding

class TestActivity:AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityTestBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}