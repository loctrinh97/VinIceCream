package com.example.vinicecream.model

import java.sql.Time

open class Voucher() {
    var id : Int? = null
    var discount : Float? = null
    var createdAt : Time? = null
    var endTime : Time? = null
}