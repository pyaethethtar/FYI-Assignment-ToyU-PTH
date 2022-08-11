package com.example.toyu.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.toyu.persistence.typeconverters.ToyImageTypeConverter

@Entity(tableName = "toys")
@TypeConverters(ToyImageTypeConverter::class)
data class ToyVO(
    @PrimaryKey
    var toyId: String = "",
    var toyName: String = "",
    var toyCategory: String = "",
    var ageCategory : String = "",
    var price : Double = 0.0,
    var rating : Double = 0.0,
    var description : String = "",
    @Embedded
    var owner : UserVO = UserVO(),
    var imageList : ArrayList<ToyImageVO> = arrayListOf(),
    var itemCount : Int = 0,
    var promotionType : String ?= null,
    var isFavorite : Boolean = false
)
