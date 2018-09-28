package com.example.user.nastya_danchenko_shop

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {

            frameLayout {
                progressBar {

                }.lparams {
                    gravity = Gravity.CENTER
                }
            }

            val request = Request.Builder()
                    .url("https://api.myjson.com/bins/nikho")
                    .build()

            val client = OkHttpClient()

            val response = async(Dispatchers.IO) {
                client.newCall(request)
                        .execute()
            }.await()

            val json = response.body()!!.string()

            val vegetables: ProductsList = JSON.parse(json)

            recyclerView {
                layoutManager = LinearLayoutManager(this@ProductsActivity)
                adapter = ProductsAdapter(products = vegetables.products, context = this@ProductsActivity)
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
        Picasso.get().load(product.imageUrl).into(holder.view.pictureView)
    }
}

class ProductView(context: Context) : FrameLayout(context) {
    lateinit var titleView: TextView // lateinit означает, что переменной
    lateinit var priceView: TextView // не нужно задавать начальное значение
    lateinit var valutaView: TextView
    lateinit var quantityView: TextView
    lateinit var descriptionView: TextView
    lateinit var pictureView: ImageView

    init {
        layoutParams = LayoutParams(matchParent, wrapContent)


        verticalLayout {

            cardView {
                radius = 50.0f
                elevation = 10.0f
                setCardBackgroundColor(Color.LTGRAY)

                verticalLayout {

                    pictureView = imageView {
                    }.lparams {
                        gravity = Gravity.CENTER
                        topMargin = dip(25)
                    }

                    titleView = textView {
                    }.lparams {
                        leftMargin = dip(35)
                        topMargin = dip(8)
                        bottomMargin = dip(4)
                    }
                    descriptionView = textView {
                    }.lparams {
                        leftMargin = dip(35)
                        topMargin = dip(4)
                        bottomMargin = dip(4)
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
                        width = matchParent
                        height = wrapContent
                        leftMargin = dip(35)
                        rightMargin = dip(35)
                        topMargin = dip(4)
                        bottomMargin = dip(8)
                    }
                }
            }.lparams {
                topMargin = dip(10)
                leftMargin = dip(10)
                rightMargin = dip(10)
                bottomMargin = dip(20)
                width = matchParent
                height = wrapContent
            }
        }
    }
}

class ProductViewHolder(val view: ProductView) : RecyclerView.ViewHolder(view)