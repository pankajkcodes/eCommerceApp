package com.pankajkcodes.ecommerceapp.db.remote

import com.pankajkcodes.ecommerceapp.model.ProductItems
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun getAllProducts(): Call<List<ProductItems>>


    companion object {
        var apiService: ApiService? = null
        private const val BASE_URL = "https://fakestoreapi.com/"

        fun getInstance(): ApiService {
            if (apiService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService!!
        }

    }

}