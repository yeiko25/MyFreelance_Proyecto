package com.example.proyecto.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.proyecto.data.ServiceDao
import com.example.proyecto.data.UserDao
import com.example.proyecto.model.Service
import com.example.proyecto.model.User

class UserRepository(private val userDao: UserDao) {

    suspend fun saveUser(user: User) {
        if (user.id_usuario==0) {
            userDao.addUser(user)
        } else {
            userDao.updateUser(user)
        }
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    val getUsers : LiveData<List<User>> = userDao.getUser()
}