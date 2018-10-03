package com.example.user.nastya_danchenko_shop

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.net.Uri
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {

        frameLayout {

            imageView {
                imageResource = R.drawable.welcom
                scaleType = ImageView.ScaleType.CENTER_CROP
            }.lparams {
                width = matchParent
                height = matchParent
            }

            verticalLayout {

                customView<HeaderView> {
                    titleView.text = "Главая"
                }

                textView {
                    text = "Hello, my friend!"
                }.lparams {
                    margin = dip(130)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                verticalLayout {


                    editText {
                        hint = "Логин"
                    }

                    editText {
                        hint = "Пароль"
                    }
                }.lparams {
                    width = matchParent
                    gravity = Gravity.CENTER

                }

                button {
                    typeface = Typeface.createFromAsset(assets, "intro_inline.otf")
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    backgroundColor = Color.BLUE
                    textSize = 27f
                    text = "Войти"
                    onClick {
                        //startActivity(Intent(this@MainActivity, AboutActivity::class.java)) -  тоже, что снизу
                        startActivity<CategoriesActivity>()
                    }
                }.lparams {
                    width = matchParent
                    gravity = Gravity.END or Gravity.CENTER_HORIZONTAL
                }

                button {
                    text = "Поделиться"
//                    onClick {
//                        val in = Intent()
//                                .setData(Uri.parse("http://twitter.com/share?text=${}"))
//                                .setAction(Intent.ACTION_VIEW)
//                        startActivity(in)
//                    }
                }


                button {
                    backgroundColor = Color.BLUE
                    text = "Войти в категории"
                    onClick {
                        startActivity<CategoriesActivity>()
                    }
                }.lparams {
                    width = matchParent
                    gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL

                }



            }
        }
    }
}