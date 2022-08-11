package com.example.toyu.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.toyu.data.vos.ToyImageVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ToyImageTypeConverter {

    @TypeConverter
    fun toString(images : ArrayList<ToyImageVO>) : String{
        return Gson().toJson(images)
    }

    @TypeConverter
    fun toArrayList(imagesJsonString: String) : ArrayList<ToyImageVO>{
        val imagesType = object : TypeToken<ArrayList<ToyImageVO>>(){}.type
        return Gson().fromJson(imagesJsonString, imagesType)
    }
}