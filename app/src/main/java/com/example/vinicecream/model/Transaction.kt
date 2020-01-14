package com.example.vinicecream.model

import com.google.gson.annotations.SerializedName
import java.sql.Time

class Transaction {
    @SerializedName("id")
    var id : Int? = null
    @SerializedName("product_name")
    var productName : String? = null
    @SerializedName("description")
    var desctiption : String? = null
    @SerializedName("images")
    var images : String? = null
    @SerializedName("quantity")
    var quantity : String? = null
    @SerializedName("create_at")
    var createAt : String? = null
    @SerializedName("update_at")
    var updateAt : String? = null
    @SerializedName("price")
    var price : Float? = null
}