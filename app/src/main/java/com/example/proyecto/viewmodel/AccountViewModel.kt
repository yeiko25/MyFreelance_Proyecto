package com.example.proyecto.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.proyecto.data.UserDataBase
import com.example.proyecto.model.User
import com.example.proyecto.repository.UserRepository
import kotlinx.coroutines.launch

class AccountViewModel(application: Application) : AndroidViewModel(application) {
    val getUser: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        getUser = repository.getUsers
    }

    fun saveUser(user: User) {
        viewModelScope.launch { repository.saveUser(user) }
    }

    fun deleteService(user: User) {
        viewModelScope.launch { repository.deleteUser(user)}
    }
}