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

class CategoriesActivity : AppCompatActivity() {
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
                    .url("https://api.myjson.com/bins/cmw9c")
                    .build()

            val client = OkHttpClient()

            val response = async(Dispatchers.IO) {
                client.newCall(request)
                        .execute()
            }.await()

            val json = response.body()!!.string()

            val point: CategoriesList = JSON.parse(json)

            recyclerView {
                layoutManager = LinearLayoutManager(this@CategoriesActivity)
                adapter = CategoriesAdapter(categories = point.categories, context = this@CategoriesActivity)
            }
        }
    }
}

@Serializable
class Categories(
        val name: String,
        val imageUrl: String
)

@Serializable
class CategoriesList(
        val categories: List<Categories>
)

class CategoriesAdapter(
        val categories: List<Categories>,
        val context: Context

) : RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun getItemCount() = categories.size
    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int)= run {
        val itemView = CategoriesView(context)
        CategoriesViewHolder(view = itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categories = categories[position]
        holder.view.nameView.text = categories.name
        Picasso.get().load(categories.imageUrl).into(holder.view.pictureView)
    }
}

class CategoriesView(context: Context) : FrameLayout(context) {
    lateinit var nameView: TextView // lateinit означает, что переменной
    lateinit var pictureView: ImageView

    init {
        layoutParams = LayoutParams(matchParent, wrapContent)


        verticalLayout {

            cardView {
                radius = 50.0f
                elevation = 10.0f
//                setCardBackgroundColor(Color.LTGRAY)

                verticalLayout {

                    pictureView = imageView {
                    }.lparams {
                        gravity = Gravity.CENTER
                        topMargin = dip(25)
                    }

                    nameView = textView {
                        textSize = 26f
                    }.lparams {
                        topMargin = dip(8)
                        bottomMargin = dip(4)
                        gravity = Gravity.CENTER_HORIZONTAL
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

class CategoriesViewHolder(val view: CategoriesView) : RecyclerView.ViewHolder(view)

