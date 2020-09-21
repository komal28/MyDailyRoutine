package com.mydailyroutine.ui.Interface

import androidx.lifecycle.LiveData

interface LoginListener {
    fun onStarted()
    fun onSuccess(loginResponse: LiveData<String>)
    fun onFailure(message:String)
}