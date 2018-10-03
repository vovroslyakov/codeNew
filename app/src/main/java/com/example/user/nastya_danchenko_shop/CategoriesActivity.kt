package com.example.user.nastya_danchenko_shop

import CategoriesView
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.kodein.di.direct
import org.kodein.di.generic.instance

class CategoriesActivity : AppCompatActivity() {

    val requestMaker: RequestMaker = di.direct.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if (Preferences.currentCategoriesUrl != null) {
//            startActivity<ProductsActivity>("url" to Preferences.currentCategoriesUrl)
//        }

        GlobalScope.launch(Dispatchers.Main) {

            frameLayout {
                progressBar {

                }.lparams {
                    gravity = Gravity.CENTER
                }
            }

            val json = async(Dispatchers.IO) {
                requestMaker.make("https://api.myjson.com/bins/1evftc")
            }.await()

            val categoriesList: CategoriesList = JSON.parse(json)


            relativeLayout {

                customView<HeaderView> {
                    titleView.text = "Меню"
                }.lparams {
                }

                verticalLayout {

                    recyclerView {
                        layoutManager = LinearLayoutManager(this@CategoriesActivity, LinearLayoutManager.HORIZONTAL, false)
                        adapter = CategoriesAdapter(categories = categoriesList.categories, context = this@CategoriesActivity)
                    }
                }.lparams{
                    verticalMargin = dip(40)
                    width = matchParent
                    height = dip(50)


                }

                customView<FooterView> {
                    imgMenu.text = "Меню"
                    imgProfile.text = "Профиль"
                    imgBox.text = "Корзина"
                }.lparams {
                    alignParentBottom()
                }
            }
        }
    }
}


@Serializable // означает что мы можем получить ее из json и записать обратно
class Categories(
        val name: String,
        val imageUrl: String,
        val url: String
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

    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int) = run {
        val itemView = CategoriesView(context)
        CategoriesViewHolder(view = itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

        val categories = categories[position]
        holder.view.nameView.text = categories.name
        holder.view.onClick {
            Preferences.currentCategoriesUrl = categories.url
            val categoriesJson = JSON.stringify(categories)
            context.startActivity<ProductsActivity>("categories" to categoriesJson)
        }
        Picasso.get().load(categories.imageUrl).into(holder.view.pictureView)
    }
}

class CategoriesViewHolder(val view: CategoriesView) : RecyclerView.ViewHolder(view)

