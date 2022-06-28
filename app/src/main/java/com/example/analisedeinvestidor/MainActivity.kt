package com.example.analisedeinvestidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.analisedeinvestidor.R
import com.example.analisedeinvestidor.databinding.ActivityMainBinding
import com.example.analisedeinvestidor.userName

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    var binding: ActivityMainBinding
        get() = _binding
        set(value) {
            _binding = value
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextButton.setOnClickListener() {
            binding.inputEditedText.text.toString().also { userName = it }

            if (userName.isEmpty()) {
                Toast.makeText(applicationContext, "Primeiro, digite o seu nome para iniciar", Toast.LENGTH_SHORT).show()
            } else {
                val showIntent = Intent(this, QActivity::class.java)
                startActivity(showIntent)
            }
        }

    }
}