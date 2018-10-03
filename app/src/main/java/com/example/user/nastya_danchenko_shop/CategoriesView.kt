import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

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
