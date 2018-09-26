package com.example.user.nastya_danchenko_shop
//
//import android.graphics.Color
//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.view.Gravity
//import com.example.user.nastya_danchenko_shop.R.attr.color
//import org.jetbrains.anko.*
//import org.jetbrains.anko.appcompat.v7.contentFrameLayout
//
//class AboutActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        frameLayout {
//
//            verticalLayout {
//            textView {
//                text = "Хороший магазин"
//                textSize = 19f
//                bottomPadding = dip(30)
//            }
//                textView {
//                    text = "Анастасия"
//
//                }
//                textView {
//                    text = "nastiadanchenko@gmail.com"
//
//                }
//                }.lparams {
//                    gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL
//            }
//            verticalLayout {
//            textView {
//                text = "IT School 2018"
//            }
//                textView {
//                    text = "#хочувайти"
//                    textColor = Color.MAGENTA
//                }
//                }.lparams {
//                    gravity = Gravity.BOTTOM or Gravity.END
//            }
//        }
//    }
//}

/*второй вар*/
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.contentFrameLayout

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frameLayout {
            verticalLayout {
                imageView {
                    setImageResource(R.drawable.image)
                }.lparams {
                    width = dip(100)
                    height = dip(100)
                    gravity = Gravity.CENTER_HORIZONTAL
                    weight = 2f
                    topMargin = dip(20)
                }
                textView {
                    text = "Хороший магазин"
                    textSize = 19f
                }.lparams {
                    leftMargin = dip(20)
                    weight = 0.25f
                }
                verticalLayout {
                    textView {
                        text = "Анастасия Д."
                    }
                    textView {
                        text = "nastiadanchenko@gmail.com"
                    }
                }.lparams {
                    weight = 3f
                    leftMargin = dip(20)
                }
                verticalLayout {
                    textView {
                        text = "IT School 2018"
                    }
                    textView {
                        text = "#хочувайти"
                        textColor = Color.MAGENTA
                    }
                }.lparams {
                    gravity = Gravity.BOTTOM or Gravity.END
                    margin = dip(20)
                }

            }
        }
    }
}

