package com.mydailyroutine.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.mydailyroutine.ui.Interface.LoginListener

class LoginViewModel :ViewModel()
{
    var userName: String? = null
    var password: String? = null
    var listener:LoginListener? = null

    fun onLoginButtonClick(view: View)
    {
        listener?.onStarted()
        if(userName.isNullOrEmpty() || password.isNullOrEmpty())
        {
            listener?.onFailure("Invalid email or password")
            return
        }
        listener?.onSuccess()

    }
}