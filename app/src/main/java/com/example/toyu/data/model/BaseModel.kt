package com.example.toyu.data.model

import android.content.Context
import com.example.toyu.persistence.db.ToyUDatabase

abstract class BaseModel {

    protected lateinit var mTheDB : ToyUDatabase

    fun initDatabase(context: Context){
        mTheDB = ToyUDatabase.getDBInstance(context)
    }
}