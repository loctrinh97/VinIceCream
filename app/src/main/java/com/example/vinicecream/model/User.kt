package com.example.vinicecream.model

import com.google.gson.annotations.SerializedName


class User {
    @SerializedName("id")
    var id : Int? = null
    @SerializedName("email")
    var email : String? = null
    @SerializedName("password")
    var password : String? = null
    @SerializedName("role")
    var role : String? = null
}