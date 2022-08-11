package com.example.toyu.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.toyu.data.vos.CartVO
import com.example.toyu.data.vos.ToyVO
import com.example.toyu.persistence.daos.CartDao
import com.example.toyu.persistence.daos.ToyDao

@Database(entities = [ToyVO::class, CartVO::class], version = 1, exportSchema = false)
abstract class ToyUDatabase : RoomDatabase(){

    companion object{
        val DB_NAME = "TOY_U_DB"
        var dbInstance : ToyUDatabase ?= null

        fun getDBInstance(context: Context) : ToyUDatabase{
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(context, ToyUDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun toyDao() : ToyDao
    abstract fun cartDao() : CartDao
}