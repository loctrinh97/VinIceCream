package com.example.vinicecream.viewmodel

import com.example.vinicecream.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {
    //Specify the request type and pass the related URL
    @get:GET("/users")
    // Wrap the response in a Call with the type of the expected result
    val allUsers: Call<List<Products>>
}