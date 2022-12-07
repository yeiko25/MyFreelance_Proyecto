package com.example.proyecto.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.proyecto.model.Service
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.ktx.Firebase

class ServiceDao {
    private var serviceId: String
    private var firestore: FirebaseFirestore


    init {
        val service = Firebase.auth.currentUser?.email
        serviceId = "$service"
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }


    fun saveService(service: Service){
        val id = firestore.collection("Services").document().id



        val document: DocumentReference
        if(service.id.isEmpty()){
            //Agregar
            document = firestore.
            collection("Servicios").
            document(id).
            collection("ServiciosMyFreelance").
            document()
            service.id = document.id
        }
        else{
            //Modificar
            document = firestore.
            collection("Services").
            document(id).
            collection("ServicesMyFreelance").
            document(service.id)
        }
        document.set(service)
            .addOnCompleteListener {
                Log.d("SaveService","Guardado con exito")
            }
            .addOnCanceledListener {
                Log.e("SaveService","Error al guardar")
            }
    }

    fun deleteService(service: Service){
        if(service.id.isNotEmpty()){
            firestore.
            collection("Services").
            document(serviceId).
            collection("ServicesMyFreelance").
            document(serviceId).
            delete()
                .addOnCompleteListener {
                    Log.d("deleteService","Eliminado con exito")
                }
                .addOnCanceledListener {
                    Log.e("deleteService","Error al eliminar")
                }
        }

    }

    fun getServices() : MutableLiveData<List<Service>> {
        val listServices = MutableLiveData<List<Service>>()
        firestore.
        collection("Services").
        document(serviceId).
        collection("ServicesMyFreelance").
        addSnapshotListener{snapshot, e ->
            if(e != null){
                return@addSnapshotListener
            }
            if(snapshot != null){
                val list = ArrayList<Service>()
                val services = snapshot.documents
                services.forEach{
                    val service = it.toObject(Service ::class.java)
                    if(service != null){
                        list.add(service)
                    }
                }
                listServices.value = list
            }
        }
        return listServices
    }

    fun GetDocId(){


    }

}