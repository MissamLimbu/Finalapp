package com.example.finalapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.Entity
import com.example.finalapp.RetrofitInstance
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    val entities = MutableLiveData<List<Entity>>()

    fun loadDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getDashboardData(keypass)
                if (response.isSuccessful) {
                    entities.postValue(response.body()?.entities)
                } else {
                    // Handle unsuccessful response (e.g., show error message)
                }
            } catch (e: Exception) {
                // Handle exceptions (e.g., network errors)
            }
        }
    }
}
