package com.example.user.nastya_danchenko_shop

import android.app.Application
import android.arch.persistence.room.Room
import com.chibatching.kotpref.Kotpref


lateinit var db: ShopDatabase   // ...потому что надо заполнять после onCreate

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)

        //class::java потому что room написан на java
        db = Room.databaseBuilder(this, ShopDatabase::class.java, "shop").build()
    }
}