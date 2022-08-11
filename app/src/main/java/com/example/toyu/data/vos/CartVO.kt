package com.example.toyu.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carts")
data class CartVO(
    @PrimaryKey
    var cartId : String = "",
    @Embedded
    var toy : ToyVO = ToyVO(),
    var quantity : Int = 0,
    var subTotal : Double = 0.0
)
