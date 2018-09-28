package com.example.user.nastya_danchenko_shop

import android.graphics.Color
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {

        frameLayout {
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
                backgroundColor = Color.BLUE
                text = "Войти"
                onClick {
                    //startActivity(Intent(this@MainActivity, AboutActivity::class.java)) -  тоже, что снизу
                    startActivity<ProductsActivity>()
                }
            }.lparams {
                width = matchParent
                gravity = Gravity.END or Gravity.CENTER_HORIZONTAL
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