package com.example.user.nastya_danchenko_shop

import CategoriesView
import android.arch.persistence.room.*
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DialogTitle
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
import java.util.*

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

            val categories = try {

                val json = async(Dispatchers.IO) {
                    requestMaker.make("https://api.myjson.com/bins/1evftc")
                }.await()

                val categoriesList: CategoriesList = JSON.parse(json)

// Как работает функция высшего порядка
//            fun foo1(a: Int, b: Int) = a + b
//            val foo2 = {a: Int, b: Int -> a + b}
//
//            fun summator(func: (a : Int, b: Int) -> Int) {
//            }
//
//            summator { a, b -> a + b }

                //Создаем базу данный в отдельном потоке
                async(Dispatchers.IO) {
                    categoriesList.categories.forEach { categories ->
                        db.categoriesDao().add(categories)
                    }
                }.await()

                categoriesList.categories

            } catch (error: Exception){

                val categoriesFromDb = async(Dispatchers.IO) {
                    db.categoriesDao().all()
                }.await()

                categoriesFromDb
            }

            //await дожидается либо результата либо ошибки

            relativeLayout {

                customView<HeaderView> {
                    titleView.text = "Меню"
                }.lparams {
                }

                verticalLayout {

                    recyclerView {
                        layoutManager = LinearLayoutManager(this@CategoriesActivity, LinearLayoutManager.HORIZONTAL, false)
                        adapter = CategoriesAdapter(categories, context = this@CategoriesActivity)
                    }
                }.lparams {
                    verticalMargin = dip(40)
                    width = matchParent
                    height = dip(200)
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

// Первая анотация означает, что этот продукт может быть преобразован в json.
// Т.е. сериализация - это преобразование объекта в язык хранения данных и обратно.
// Эту работу сделал спец плагин, который мы поключили.
// Вторая анотация для бд. Работает аналогичным образом.
@Serializable
@Entity(tableName = "categories")
class Categories(
        @PrimaryKey val id: Int, //анотация озачает что индекс будет создаваться по этому полю
        val name: String,
        val imageUrl: String,
        val url: String
//        val rating: Double,
//        val productsCount: Int
)

//Запросы к бд описываются в спец. интерфейсе Dao (data access object).
//Запросы это обычные функции помеченные спец. анотациями.
@Dao
interface CategoriesDao {

    @Insert //Анотация означает (для Room'a) что это запрос добавления
    fun add(category: Categories)

    @Query("SELECT * FROM categories")
    fun all(): List<Categories>

    @Query("SELECT * FROM categories WHERE id=:id")
    fun byId(id: Int): Categories

//    @Query("SELECT * FROM categories WHERE rating >= 3.0 AND productsCount > 0 ")
//    fun notEmptyWithHighRating(): List<Categories>
}

// т.к. таблиц внутри бд может быть много, то надо описать ее отдельно
// в абстрактном классе, чтобы не прописывать конкретные действия
// их сделает плагин за нас
// надо добавить анотацию и указать сущности (тут надо обратиться к самому классу, если не сделать
// :: class, то полусится что мы обратились к конструктору)
@Database(entities = [Categories::class], version = 1) // more in google: android room migrations
abstract class ShopDatabase : RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao
}




