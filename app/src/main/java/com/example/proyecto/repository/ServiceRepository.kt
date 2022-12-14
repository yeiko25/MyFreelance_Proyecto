package com.example.proyecto.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.proyecto.data.ServiceDao
import com.example.proyecto.model.Service

class ServiceRepository(private val serviceDao: ServiceDao) {

    suspend fun saveService(service: Service) {
        if (service.id_servicio==0) {
            serviceDao.addService(service)
        } else {
            serviceDao.updateService(service)
        }
    }

    suspend fun deleteService(service: Service) {
        serviceDao.deleteService(service)
    }

    val getServices : LiveData<List<Service>> = serviceDao.getService()
}