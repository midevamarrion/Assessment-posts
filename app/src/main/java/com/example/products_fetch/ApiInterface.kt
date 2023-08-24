package com.example.products_fetch

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface `API-INterface` {

    @GET("/product")
    suspend fun getProducts(): Response<ProductResponse>
    @GET("/product/{Id}")
    suspend fun getProductById(@Path("id")productId: Int):Response<Products>


}