package com.example.projectandroidadmin.utils

import com.example.projectandroidadmin.services.getDataAPI
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object connections {
    private const val BASE_URL = "http://192.168.1.3/AdminBankSampah/appstarter/public/"

//    fun getRetroClientInstance(): Retrofit {
//        val gson = GsonBuilder().setLenient().create()
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    }

    val getRetroClientInstance : getDataAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(getDataAPI::class.java)
    }
}