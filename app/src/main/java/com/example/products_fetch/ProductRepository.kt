package com.example.products_fetch

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {
    val apiClient=`API-Client`.buildClient(`API-INterface`::class.java)
    suspend fun getProducts(): Response<ProductResponse> {
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }

    }
}