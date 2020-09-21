package com.mydailyroutine.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface api {
    companion object {

        operator fun  invoke() : api{
            return Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(api::class.java)
        }
        const val baseUrl = ""
    }

    //apiFunctions

    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        @Field("email") email :String,
        @Field("password") password :String
    ): Call<ResponseBody>
}