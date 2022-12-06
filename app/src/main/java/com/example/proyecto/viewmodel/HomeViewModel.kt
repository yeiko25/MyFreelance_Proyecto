package com.example.proyecto.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto.data.UserDao
import com.example.proyecto.model.User
import com.example.proyecto.repository.UserRepository


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    val getUsers : MutableLiveData<List<User>>
    private val repository: UserRepository = UserRepository(UserDao())

    init {
        getUsers = repository.getUsers
    }

    fun saveUser(user: User) {
        repository.saveUser(user)
    }

    fun deleteUser(user: User) {
        repository.deleteUser(user)
    }
}