package com.example.english_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.english_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.buttonTest.setOnClickListener {
            val intent= Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

        binding.buttonDictionary.setOnClickListener {
            val intent= Intent(this,DictionaryActivity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}