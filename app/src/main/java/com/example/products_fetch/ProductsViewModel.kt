package com.example.products_fetch


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_products.models.Products
import com.example.api_products.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductsViewModel:ViewModel() {
    var productsRepository=ProductRepository()
    val productsLiveData=MutableLiveData<List<Products>>()
    val errorLiveData=MutableLiveData<String>()

    fun fetchProducts(){
        viewModelScope.launch {
            val response=productsRepository.getProducts()
            if (response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}