package com.example.vinicecream.view.api

import com.example.vinicecream.model.Products
import com.example.vinicecream.model.Profile
import com.example.vinicecream.model.Transaction
import com.example.vinicecream.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIServices {
    //Specify the request type and pass the related URL
    //@get:GET("/users")
    // Wrap the response in a Call with the type of the expected result

    @get:GET("/product/mobile")
    val allProducts: Call<List<Products>>

    @get:GET("/product")
    val allOrder: Call<List<Transaction>>

    @POST("/user/login")
    @Headers("Content-Type: application/json")
    fun checkLogin(
        @Body user: User
    ): Call<User>


    @POST("/user")
    @Headers("Content-Type: application/json")
    fun createUser(
        @Body profile: Profile
    ) : Call<Profile>
}