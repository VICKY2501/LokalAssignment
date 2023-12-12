package com.example.lokalassignment.repository

import com.example.lokalassignment.dataclasses.ProductsResponse
import com.example.lokalassignment.retrofit.RetroFit

class ProductRepository {
    suspend fun getProducts():ProductsResponse{
        return RetroFit.apiInstance.getProducts()
    }
}