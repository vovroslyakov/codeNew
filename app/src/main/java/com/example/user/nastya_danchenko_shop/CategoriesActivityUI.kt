package com.example.user.nastya_danchenko_shop

import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class CategoriesActivityUI : AnkoComponent<CategoriesActivity> {
    override fun createView(ui: AnkoContext<CategoriesActivity>): View = with(ui) {

        frameLayout {
            verticalLayout {

                button {
                    text = "Сеты"
                }.lparams {
                    height = wrapContent
                    width = matchParent
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                button {
                    text = "Ролы"
                }.lparams {
                    height = wrapContent
                    width = matchParent
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                button {
                    text = "Пицца"
                }.lparams {
                    height = wrapContent
                    width = matchParent
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                button {
                    text = "Напитки"
                    onClick {
                        startActivity<ProductsActivity>()
                    }
                }.lparams {
                    height = wrapContent
                    width = matchParent
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                button {
                    text = "Дополнительно"
                }.lparams {
                    height = wrapContent
                    width = matchParent
                    gravity = Gravity.CENTER_HORIZONTAL
                }

            }.lparams {
                gravity = Gravity.CENTER
                width = matchParent
                margin = dip(20)
            }
        }
    }
}

