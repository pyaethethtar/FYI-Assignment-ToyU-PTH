package com.example.toyu.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.toyu.data.vos.ToyVO

@Dao
interface ToyDao {

    @Query("Select * From toys")
    fun getAllToys() : LiveData<List<ToyVO>>

    @Query("Select * From toys Where toyId=:toyId")
    fun getToyById(toyId : String) : LiveData<ToyVO>

    @Insert
    fun addAllToyList(toys : List<ToyVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToy(toy : ToyVO)

    @Update
    fun updateToy(toy : ToyVO)

    @Query("Delete From toys")
    fun deleteAllToys()

    @Delete
    fun deleteToy(toy : ToyVO)
}