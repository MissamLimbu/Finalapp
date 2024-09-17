package com.example.finalapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.finalapp.LoginRequest
import com.example.finalapp.LoginResponse


class LoginViewModel : ViewModel() {
    val loginSuccess = MutableLiveData<String>()
    val loginError = MutableLiveData<Boolean>()

    fun login(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.login(loginRequest)
                if (response.isSuccessful && response.body() != null) {
                    loginSuccess.postValue(response.body()?.keypass)
                } else {
                    loginError.postValue(true)
                }
            } catch (e: Exception) {
                loginError.postValue(true)
            }
        }
    }
}
