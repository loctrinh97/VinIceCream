package com.example.vinicecream.model

import com.google.gson.annotations.SerializedName
import java.sql.Time

class Products {
    var id : Int? = null
    @SerializedName("name")
    var productName : String? = null
    var desctiption : String? = null
    var images : String? = null
    var createAt : Time? = null
    var updateAt : Time? = null
    var categoryId : Int? = null
    var price : Float? = null
}