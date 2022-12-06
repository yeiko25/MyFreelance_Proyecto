package com.example.proyecto.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.proyecto.model.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.ktx.Firebase

class UserDao {
    private var codigoUsuario: String
    private var firestore: FirebaseFirestore


    init {
        val usuario = Firebase.auth.currentUser?.email
        codigoUsuario = "$usuario"
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }


    fun saveUser(user: User){
        val id = firestore.collection("Usuarios").document().id



        val document: DocumentReference
        if(user.id.isEmpty()){
            //Agregar
            document = firestore.
            collection("Usuarios").
            document(id).
            collection("UsuariosMyFreelance").
            document()
            user.id = document.id
        }
        else{
            //Modificar
            document = firestore.
            collection("Usuarios").
            document(id).
            collection("UsuariosMyFreelance").
            document(user.id)
        }
        document.set(user)
            .addOnCompleteListener {
                Log.d("SaveUser","Guardado con exito")
            }
            .addOnCanceledListener {
                Log.e("SaveUser","Error al guardar")
            }
    }

    fun deleteUser(user: User){
        if(user.id.isNotEmpty()){
            firestore.
            collection("Usuarios").
            document(codigoUsuario).
            collection("UsuariosMyFreelance").
            document(user.id).
            delete()
                .addOnCompleteListener {
                    Log.d("deleteUser","Eliminado con exito")
                }
                .addOnCanceledListener {
                    Log.e("deleteUser","Error al eliminar")
                }
        }

    }

    fun getUsers() : MutableLiveData<List<User>> {
        val listaUsuarios = MutableLiveData<List<User>>()
        firestore.
        collection("Usuarios").
        document(codigoUsuario).
        collection("UsuariosMyFreelance").
        addSnapshotListener{snapshot, e ->
            if(e != null){
                return@addSnapshotListener
            }
            if(snapshot != null){
                val lista = ArrayList<User>()
                val usuarios = snapshot.documents
                usuarios.forEach{
                    val user = it.toObject(User ::class.java)
                    if(user != null){
                        lista.add(user)
                    }
                }
                listaUsuarios.value = lista
            }
        }
        return listaUsuarios
    }

    fun GetDocId(){


       }

}