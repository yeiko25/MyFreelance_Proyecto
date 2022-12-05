package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.proyecto.databinding.ActivityRegisterBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth


        binding.btLogin1.setOnClickListener() {
            val LoginIntent = Intent(this, Login::class.java).apply {
            }
            startActivity(LoginIntent)

        }

        binding.btRegister1.setOnClickListener { register() }

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

    private fun register() {
        title = "Registro"

        val email = binding.etEmail1.text.toString().trim()
        val clave = binding.etClave1.text.toString().trim()
        val nombre = binding.etNombre.text.toString().trim()
        val apellido = binding.etApellido.text.toString().trim()
        val direccion = binding.etDireccion.text.toString().trim()
        val telefono = binding.etTelefono.text.toString().trim()
        val n_usuario = binding.etUsuario.text.toString().trim()


        if (email.isEmpty() || clave.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
            || direccion.isEmpty() || telefono.isEmpty() || n_usuario.isEmpty()) {

            Toast.makeText(baseContext, "Por favor rellene todo los campos", Toast.LENGTH_LONG)
                .show()

        } else {

            auth.createUserWithEmailAndPassword(email, clave).addOnCompleteListener(this) {
                    task -> if (task.isSuccessful) {
                    Log.d("Creando Usuario", "Registrado")
                    val user = auth.currentUser
                    if (user != null) {
                        refresh(user)
                    }
                } else {
                    Log.d("Creando Usuario", "Error")
                    Toast.makeText(baseContext, "Error", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}