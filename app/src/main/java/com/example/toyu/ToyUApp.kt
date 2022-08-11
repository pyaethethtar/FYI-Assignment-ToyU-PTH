package com.example.toyu

import android.app.Application
import com.example.toyu.data.model.ToyUModelImpl
import com.example.toyu.dummy.getDummyToyList

class ToyUApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ToyUModelImpl.initDatabase(applicationContext)
        ToyUModelImpl.saveToyListToDatabase(getDummyToyList())
    }
}