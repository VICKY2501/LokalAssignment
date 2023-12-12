package com.example.lokalassignment.dataclasses

data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: String,
    val id: Int,
    val images: ArrayList<String>,
    val price: String,
    val rating: Float,
    val stock: String,
    val thumbnail: String,
    val title: String
)