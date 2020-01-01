package com.example.vinicecream.model

import java.sql.Time

class Transaction {
    var id : Int? = null
    var userId : Int? = null
    var createAt : Time? = null
    var updateAt : Time? = null
    var totalPrice : Float? = null
    var address : String? = null
}