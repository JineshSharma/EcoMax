package com.example.ecomax

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("/v1/current.json")
    suspend fun getData(
        @Query("q") cityName: String,
        @Query("key") key: String
    ): Response<JSONObject>?

}