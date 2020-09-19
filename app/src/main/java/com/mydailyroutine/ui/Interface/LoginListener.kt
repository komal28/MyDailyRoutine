package com.mydailyroutine.ui.Interface

interface LoginListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}