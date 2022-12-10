package com.example.proyecto.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.proyecto.data.ServiceDao
import com.example.proyecto.model.Service
import com.example.proyecto.repository.ServiceRepository

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    val getServices : MutableLiveData<List<Service>>
    private val repository: ServiceRepository = ServiceRepository(ServiceDao())

    init {
        getServices = repository.getServices
    }

    fun saveService(service: Service) {
        repository.saveService(service)
    }

    fun deleteService(service: Service) {
        repository.deleteService(service)
    }

}