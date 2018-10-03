package com.example.user.nastya_danchenko_shop

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.serialization.json.JSON
import kotlinx.serialization.json.json
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val json = intent.getStringExtra("product")
        val product: Product = JSON.parse(json)

        verticalLayout {
            backgroundColor = Color.RED
            textView {
                text = product.title
            }
            textView {
                text = product.price.toString()
            }
        }


    }
}
