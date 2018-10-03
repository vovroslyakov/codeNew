package com.example.user.nastya_danchenko_shop

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.kodein.di.direct
import org.kodein.di.generic.instance

class ProductsActivity : AppCompatActivity() {

    //val requestMaker: RequestMaker by di.instance() или так
    val requestMaker: RequestMaker = di.direct.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {

            frameLayout {
                progressBar {

                }.lparams {
                    gravity = Gravity.CENTER
                }
            }

            val categoriesJson = intent.getStringExtra("categories")
            val categories: Categories = JSON.parse(categoriesJson)

            val json = async(Dispatchers.IO) {
                requestMaker.make(categories.url)
            }.await()
            val vegetables: ProductsList = JSON.parse(json)

            verticalLayout {

                customView<HeaderView> {
                    titleView.text = categories.name
                }.lparams {
                }

                recyclerView {
                    layoutManager = LinearLayoutManager(this@ProductsActivity)
                    adapter = ProductsAdapter(products = vegetables.products, context = this@ProductsActivity)
                }.lparams {
                }

                customView<FooterView> {
                    imgMenu.text = "Меню"
                    imgProfile.text = "Профиль"
                    imgBox.text = "Корзина"
                }.lparams {
                }
            }
        }
    }
}

@Serializable
class Product(
        val title: String,
        val price: Double,
        val valuta: String,
        val quantity: String,
        val description: String,
        val imageUrl: String
)

@Serializable

class ProductsList(
        val products: List<Product>
)

class ProductsAdapter(
        val products: List<Product>,
        val context: Context

) : RecyclerView.Adapter<ProductViewHolder>() {
    override fun getItemCount() = products.size

    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int) = run {
        val itemView = ProductView(context)
        ProductViewHolder(view = itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = products[position]
        holder.view.titleView.text = product.title
        holder.view.priceView.text = product.price.toString()
        holder.view.valutaView.text = product.valuta
        holder.view.quantityView.text = product.quantity
        holder.view.descriptionView.text = product.description

        holder.view.onClick {
            val json = JSON.stringify(product)
            context.startActivity<ProductDetailsActivity>(
            "product" to json
            )
        }

        Picasso.get().load(product.imageUrl).into(holder.view.pictureView)
    }
}

class ProductViewHolder(val view: ProductView) : RecyclerView.ViewHolder(view)