package com.pankajkcodes.ecommerceapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pankajkcodes.ecommerceapp.model.ProductItems
import com.pankajkcodes.ecommerceapp.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val productList = MutableLiveData<List<ProductItems>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllProducts() {
        val response = repository.getAllProducts()
        response.enqueue(object : Callback<List<ProductItems>> {
            override fun onResponse(
                call: Call<List<ProductItems>>,
                response: Response<List<ProductItems>>
            ) {
                productList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<ProductItems>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}