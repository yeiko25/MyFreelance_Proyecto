package com.example.proyecto.data


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.proyecto.model.Service


@Dao
interface ServiceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addService(service: Service)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateService(service: Service)

    @Delete
    suspend fun deleteService(service: Service)

    @Query("SELECT * FROM Servicios")
    fun getService() : LiveData<List<Service>>
}