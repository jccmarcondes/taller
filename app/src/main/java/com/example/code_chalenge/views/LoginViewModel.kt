package com.example.code_chalenge.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _result = MutableLiveData(Boolean)
    val result: LiveData<Boolean> = _result


    fun login(username: String, password: String) {
        if (username == "admin" && password == "1234") _result.postValue(true)
        else _result.postValue(false)
    }
}