package com.pankajkcodes.ecommerceapp.repository

import com.pankajkcodes.ecommerceapp.db.remote.ApiService

class MainRepository constructor(private val apiService: ApiService){

    fun getAllProducts() = apiService.getAllProducts()
}