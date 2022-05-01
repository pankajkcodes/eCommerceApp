package com.pankajkcodes.ecommerceapp.model

data class ProductItems(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)