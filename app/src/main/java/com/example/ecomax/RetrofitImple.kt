package com.example.ecomax

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImple {

    companion object{
        fun getInstance(): ApiService
        {
            var okHttpInteceptor = HttpLoggingInterceptor()
            okHttpInteceptor.level= HttpLoggingInterceptor.Level.BODY

            var client = OkHttpClient.Builder()
            client.addInterceptor(okHttpInteceptor)
            client.addInterceptor { it->
                var request = it.request()
                it.proceed(request)
            }


            var apiService= Retrofit.Builder().baseUrl("https://api.weatherapi.com/").
            addConverterFactory(GsonConverterFactory.create()).client(client.build()).
            build().create(ApiService::class.java)

            return  apiService

        }


    }
}