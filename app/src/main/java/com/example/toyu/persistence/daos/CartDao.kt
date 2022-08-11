package com.example.toyu.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.toyu.data.vos.CartVO

@Dao
interface CartDao {

    @Query("Select * From carts")
    fun getAllCarts() : LiveData<List<CartVO>>

    @Query("Select * From carts Where cartId=:cartId")
    fun getCartById(cartId : String) : LiveData<CartVO>

    @Insert
    fun addAllCartList(carts : List<CartVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCart(cart : CartVO)

    @Update
    fun updateCart(cart : CartVO)

    @Query("Delete From carts")
    fun deleteAllCarts()

    @Delete
    fun deleteCart(cart: CartVO)
}