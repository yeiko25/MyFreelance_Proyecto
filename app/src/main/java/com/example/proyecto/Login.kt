package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.proyecto.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth


        binding.btLogin.setOnClickListener{ login() }


        binding.btRegister.setOnClickListener{
            val RegisterIntent = Intent(this, Register::class.java).apply {
            }
            startActivity(RegisterIntent)
        }

    }

    public override fun onStart(){
        super.onStart()
        val usuario = auth.currentUser
        refresh(usuario)
    }


    private fun refresh(user: FirebaseUser?){
        if(user != null){
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }


    private fun login() {
        val email = binding.etEmail.text.toString().trim()
        val clave = binding.etClave.text.toString().trim()

        if(email.isEmpty() || clave.isEmpty()){
            Toast.makeText(baseContext, "Por favor " +
                    "rellene todo los campos", Toast.LENGTH_LONG).show()
        }else {

            auth.signInWithEmailAndPassword(email, clave).addOnCompleteListener(this) {

                    task ->
                if (task.isSuccessful) {
                    Log.d("Autenticando", "Autenticado")
                    val user = auth.currentUser
                    if (user != null) {
                        refresh(user)
                    }
                } else {
                    Log.d("Autenticando", "Error")
                    Toast.makeText(baseContext, "Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}
