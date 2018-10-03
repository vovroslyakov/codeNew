package com.example.user.nastya_danchenko_shop

import android.content.Context
import android.graphics.Typeface
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView

class FooterView(context: Context) : LinearLayout(context) {
    lateinit var imgMenu: TextView
    lateinit var imgProfile: TextView
    lateinit var imgBox: TextView

    init {
        imgMenu = textView{
            typeface = Typeface.createFromAsset(context.assets, "intro_inline.otf")
            textSize = 23f
        }

        imgProfile = textView{
            typeface = Typeface.createFromAsset(context.assets, "intro_inline.otf")
            textSize = 23f
        }

        imgBox = textView{
            typeface = Typeface.createFromAsset(context.assets, "intro_inline.otf")
            textSize = 23f
        }
    }
}