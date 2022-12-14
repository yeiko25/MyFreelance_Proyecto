package com.example.proyecto.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyecto.data.ServiceDao
import com.example.proyecto.data.ServiceDataBase
import com.example.proyecto.model.Service
import com.example.proyecto.repository.ServiceRepository
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    val getService: LiveData<List<Service>>
    private val repository: ServiceRepository

    init {
        val serviceDao = ServiceDataBase.getDatabase(application).serviceDao()
        repository = ServiceRepository(serviceDao)
        getService = repository.getServices
    }

    fun saveService(service: Service) {
        viewModelScope.launch { repository.saveService(service) }
    }

    fun deleteService(service: Service) {
        viewModelScope.launch { repository.deleteService(service)}
    }
}