package com.example.vinicecream.model

import com.google.gson.annotations.SerializedName


class User {
    @SerializedName("email")
    var email : String? = null
    @SerializedName("password")
    var password : String? = null
}