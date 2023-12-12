package com.example.lokalassignment.retrofit

import com.example.lokalassignment.dataclasses.ProductsResponse
import retrofit2.http.GET

interface APIservices {
    @GET("/products")
    suspend fun getProducts(): ProductsResponse
}