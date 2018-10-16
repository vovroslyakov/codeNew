package com.example.user.nastya_danchenko_shop

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView

class HeaderView(context: Context) : FrameLayout(context) {

    lateinit var titleView: TextView

    init {
        titleView = textView{
            typeface = Typeface.createFromAsset(context.assets, "intro_inline.otf")
            textSize = 23f
            padding = dip(15)
        }
    }


}

