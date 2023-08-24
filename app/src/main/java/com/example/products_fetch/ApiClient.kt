package com.example.products_fetch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object `API-Client` {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/posts")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <T> buildClient(apiInterface: Class<T>): T{
        return  retrofit.create(apiInterface)
    }
}
