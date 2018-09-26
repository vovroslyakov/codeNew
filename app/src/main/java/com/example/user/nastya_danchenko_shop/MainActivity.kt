package com.example.user.nastya_danchenko_shop

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//            this.resources

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

                        //                     startActivity(Intent(this@MainActivity, AboutActivity::class.java)) -  тоже, что снизу
                        startActivity<ProductsActivity>()

                    }

                }.lparams {
                    width = matchParent
                    gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL

                }

            }

        }
    }

