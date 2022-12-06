package com.example.proyecto.repository

import androidx.lifecycle.MutableLiveData
import com.example.proyecto.data.UserDao
import com.example.proyecto.model.User

class UserRepository(private val userDao: UserDao) {

    fun saveUser(user: User) {
        userDao.saveUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    val getUsers : MutableLiveData<List<User>> = userDao.getUsers()
}