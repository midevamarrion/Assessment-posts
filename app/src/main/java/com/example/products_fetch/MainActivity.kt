package com.example.products_fetch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_products.api.`API-Client`
import com.example.api_products.api.`API-INterface`
import com.example.api_products.databinding.ActivityMainBinding
import com.example.api_products.models.ProductAdapter
import com.example.api_products.models.ProductResponse
import com.example.api_products.viewModel.ProductsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val productsViewModel: ProductsViewModel by viewModels()
    private lateinit var productAdapter: ProductAdapter
    private lateinit var binding: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AppCompatActivity().inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView: RecyclerView = binding.rvProducts
        recyclerView.layoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(emptyList())
        recyclerView.adapter = productAdapter
    }

    override fun onResume() {
        super.onResume()
        productsViewModel.fetchProducts()
        productsViewModel.productsLiveData.observe(this, Observer { productLists ->
            var productAdapter = ProductAdapter(productLists ?: emptyList())

            binding.rvProducts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvProducts.adapter = productAdapter
            Toast.makeText(baseContext, "fetched ${productLists?.size} products", Toast.LENGTH_LONG)
                .show()

        })

        productsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()


        })
    }

}