package com.example.user.nastya_danchenko_shop

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.GradientDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.contentFrameLayout
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.custom.style

class IntroActivity : AnkoComponent<MainActivity>, AppCompatActivity() {

    fun buttonBg() = GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = 50f
        setStroke(2, color)
    }


    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {

        relativeLayout {

            verticalLayout {

                imageView {
                    imageResource = R.drawable.logo_hide
                    scaleType = ImageView.ScaleType.FIT_CENTER
                }.lparams {
                    height = 400
                    width = wrapContent
                    topMargin = dip(50)
                }

                textView {
                    text = "В каком Вы городе?"
                    textColorResource = R.color.colorBlack
                }.lparams {
                    width = matchParent
                    topMargin = dip(100)
                    leftMargin = dip(24)
                }

                linearLayout {

                    button {

                        text = "Челябинск"

                    }.lparams {
                        topMargin = dip(10)
                        leftMargin = dip(24)
                    }

                    textView {
                        text = "Екатеринбург"
                    }.lparams {
                        topMargin = dip(10)
                        leftMargin = dip(24)
                    }
                }.lparams {
                    width = matchParent
                }

                textView {
                    textColorResource = R.color.colorBlack
                    text = "Как Вы хотите оформить заказ?"
                }.lparams {
                    width = matchParent
                    topMargin = dip(100)
                    leftMargin = dip(24)
                }


                linearLayout {
                    textView {
                        text = "Доставка"
                    }

                    textView {
                        text = "Самовывоз"
                    }
                }

            }

                button {
                    textSize = 16F
                    textResource = R.string.button_menu
                    backgroundResource = R.drawable.button_temp


                }.lparams {
                    margin = dip(10)
                    width = matchParent
                    alignParentBottom()
                }

            }



//            textView {
//                text = "Хороший магазин"
//                textSize = 19f
//            }.lparams {
//                leftMargin = dip(20)
//            }
//
//            textView {
//                text = "Анастасия Д."
//            }
//
//            textView {
//                text = "nastiadanchenko@gmail.com"
//            }.lparams {
//                leftMargin = dip(20)
//            }
//
//            textView {
//                text = "IT School 2018"
//            }
//
//            textView {
//                text = "#хочувайти"
//                textColor = Color.MAGENTA
//            }.lparams {
//                gravity = Gravity.BOTTOM or Gravity.END
//                margin = dip(20)
//            }


    }
}

