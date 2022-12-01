package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyecto.databinding.ActivityRegisterBinding
import com.google.firebase.FirebaseApp

class Register : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        // auth = Firebase.auth


        binding.btLogin1.setOnClickListener() {
            val LoginIntent = Intent(this, Login::class.java).apply {
            }
            startActivity(LoginIntent)

        }

        binding.btRegister1.setOnClickListener() {

        }

    }
}