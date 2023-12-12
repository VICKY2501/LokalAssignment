package com.example.lokalassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokalassignment.dataclasses.ProductsResponse
import com.example.lokalassignment.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {
    val repository=ProductRepository()
    var productResponse=MutableLiveData<ProductsResponse>()

    fun getProducts(onFailure:(e:Exception)->Unit){
        viewModelScope.launch {
            try{
                productResponse.value=repository.getProducts()
            }
            catch (e:Exception){
                onFailure.invoke(e)
            }
        }
    }

}