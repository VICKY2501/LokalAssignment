package com.example.lokalassignment.dataclasses

data class ProductsResponse(
    val limit: Int,
    val products: ArrayList<Product>,
    val skip: Int,
    val total: Int
)