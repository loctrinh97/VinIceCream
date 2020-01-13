package com.example.vinicecream.model

import com.google.gson.annotations.SerializedName


class Profile {
    @SerializedName("id")
    var id : Int? = null
    @SerializedName("email")
    var email : String? = null
    @SerializedName("numberphone")
    var numberphone : String? = null
    @SerializedName("fullName")
    var userName : String? = null
    @SerializedName("password")
    var password : String? = null
    @SerializedName("role")
    var role : String? = null
    @SerializedName("total_cash")
    var total_cash : Float? = null
}