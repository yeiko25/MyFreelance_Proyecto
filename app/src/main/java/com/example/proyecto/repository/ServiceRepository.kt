package com.example.proyecto.repository

import androidx.lifecycle.MutableLiveData
import com.example.proyecto.data.ServiceDao
import com.example.proyecto.model.Service

class ServiceRepository(private val serviceDao: ServiceDao) {

    fun saveService(service: Service) {
        serviceDao.saveService(service)
    }

    fun deleteService(service: Service) {
        serviceDao.deleteService(service)
    }

    val getServices : MutableLiveData<List<Service>> = serviceDao.getServices()
}