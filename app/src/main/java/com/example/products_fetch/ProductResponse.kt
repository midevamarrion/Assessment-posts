package com.example.products_fetch

data class ProductResponse(
    var products:List<Products>,
    var userId:Int,
    var it:Int,
    var title:String,
    var body:String,

)
