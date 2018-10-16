package com.example.user.nastya_danchenko_shop

import android.content.Context
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class ProductView(context: Context) : FrameLayout(context) {
    lateinit var titleView: TextView // lateinit означает, что переменной
    lateinit var priceView: TextView // не нужно задавать начальное значение
    lateinit var valutaView: TextView
    lateinit var quantityView: TextView
    lateinit var descriptionView: TextView
    lateinit var pictureView: ImageView

    init {
        layoutParams = LayoutParams(matchParent, matchParent)

        verticalLayout {

            frameLayout {

                pictureView = imageView {

                }.lparams {
                    //                        gravity = Gravity.CENTER
//                        topMargin = dip(25)
//                width = matchParent

                }

            }

            //            cardView {
//                radius = 50.0f
//                elevation = 10.0f
//                setCardBackgroundColor(Color.LTGRAY)

//                verticalLayout {


            titleView = textView {
            }.lparams {
                //                        leftMargin = dip(35)
//                        topMargin = dip(8)
//                        bottomMargin = dip(4)
            }
            descriptionView = textView {
            }.lparams {
                //                        leftMargin = dip(35)
//                        topMargin = dip(4)
//                        bottomMargin = dip(4)
            }

            linearLayout {

                priceView = textView {
                }.lparams {
                    weight = 1f
                }

                valutaView = textView {
                }.lparams {
                    weight = 5f
                }

                quantityView = textView {
                }
            }.lparams {
                //                        width = matchParent
//                        height = wrapContent
//                        leftMargin = dip(35)
//                        rightMargin = dip(35)
//                        topMargin = dip(4)
//                        bottomMargin = dip(8)
            }

            button {
                text = "Добавить в корзину"
            }
//                }.lparams {
//                topMargin = dip(10)
//                leftMargin = dip(10)
//                rightMargin = dip(10)
//                bottomMargin = dip(20)
//                width = matchParent
//                height = wrapContent
        }
    }
}

//    }
//}