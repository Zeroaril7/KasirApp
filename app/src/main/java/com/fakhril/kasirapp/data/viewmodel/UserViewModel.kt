package com.fakhril.kasirapp.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.fakhril.kasirapp.data.db.KasirDatabase
import com.fakhril.kasirapp.data.entity.User
import com.fakhril.kasirapp.data.repo.KasirRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    val repository : KasirRepository
    val getuser: LiveData<List<User>>

    init {
        val dao = KasirDatabase.getDatabase(application).getKasirDao()
        repository = KasirRepository(dao)
        getuser = repository.users
    }

    fun insertUser(user: User )= viewModelScope.launch(Dispatchers.IO){
        repository.insertUser(user)
    }

    fun deleteUser(user: User) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteUser(user)
    }

    fun updateUser(user: User) = viewModelScope.launch(Dispatchers.IO){
        repository.updateUser(user)
    }
}