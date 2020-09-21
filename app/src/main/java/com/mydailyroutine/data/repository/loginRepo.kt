package com.mydailyroutine.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mydailyroutine.data.network.api
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback as Callback1

class loginRepo {
    fun userLogin(username: String, password: String): LiveData<String> {
        val loginResponse = MutableLiveData<String>()

        //later inject with dependency injection
        api().userLogin(username, password).enqueue(object : Callback1<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    loginResponse.value = response.body()?.string()
                } else {
                    loginResponse.value = response.errorBody()?.string()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loginResponse.value = t.message
            }

        })
        return loginResponse
    }
}