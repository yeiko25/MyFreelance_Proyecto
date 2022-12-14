package com.example.proyecto.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.proyecto.model.Service
import com.example.proyecto.model.User


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM Usuarios")
    fun getUser() : LiveData<List<User>>
}