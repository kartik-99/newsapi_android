package com.example.kartik.bulletin.Channels

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import com.example.kartik.bulletin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class SourceCard_UI<T> : AnkoComponent<T> {
    override fun createView(ui: AnkoContext<T>) = with(ui){
        verticalLayout {
            cardView {
                lparams{
                    width = matchParent
                    height = wrapContent
                    padding = dip(10)
                    margin = dip(10)
                }
                imageView {
                    id = R.id.sourcecard_category_imageview
                    backgroundColor = Color.BLACK
                }.lparams{
                    width = dip(20)
                    height = matchParent
                }
                relativeLayout {
                    lparams{
                        width = matchParent
                        height = matchParent
                        //setPadding(40,0,0,0)
                        setMargins(60,0,0,0)
                    }

                    textView {
                        id = R.id.sourcecard_title
                        text = "Title"
                        gravity = Gravity.LEFT
                        textSize = 25f
                        textColor = Color.BLACK
                    }.lparams{
                        width = matchParent
                        height = wrapContent
                    }


                    textView {
                        id = R.id.sourcecard_description
                        text = "Description"
                        padding = dip(5)
                    }.lparams{
                        width = matchParent
                        height = wrapContent

                        below(R.id.sourcecard_title)
                    }


                    textView {
                        id = R.id.sourcecard_lang
                        text = "Language"
                        padding = dip(5)
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                        bottomOf(R.id.sourcecard_description)
                    }
                }
            }
        }
    }

}