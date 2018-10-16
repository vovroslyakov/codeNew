package com.example.user.nastya_danchenko_shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(findViewById(R.id.my_toolbar))

//        MainActivityUI().setContentView(this)
        IntroActivity().setContentView(this)
        }
    }

