package com.fakhril.kasirapp.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.fakhril.kasirapp.data.db.KasirDatabase
import com.fakhril.kasirapp.data.entity.Meja
import com.fakhril.kasirapp.data.repo.KasirRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TableViewModel(application: Application): AndroidViewModel(application) {
    val repository : KasirRepository
    val getTable: LiveData<List<Meja>>

    init {
        val dao = KasirDatabase.getDatabase(application).getKasirDao()
        repository = KasirRepository(dao)
        getTable = repository.tables
    }

    fun insertTable(meja: Meja)= viewModelScope.launch(Dispatchers.IO){
        repository.insertTable(meja)
    }

    fun deleteTable(meja: Meja) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteTable(meja)
    }

    fun updateTable(meja: Meja) = viewModelScope.launch(Dispatchers.IO){
        repository.updateTable(meja)
    }

}