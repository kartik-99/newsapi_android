package com.example.kartik.bulletin

import android.graphics.Color
import android.view.Gravity
import android.view.View
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
                relativeLayout {
                    lparams{
                        width = matchParent
                        height = matchParent
                    }

                    textView {
                        id = R.id.sourcecard_title
                        text = "Title"
                        gravity = Gravity.CENTER
                        textColor = Color.WHITE
                        backgroundColor = Color.BLACK
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
                        id = R.id.sourcecard_category
                        text = "Category"
                        padding = dip(5)
                    }.lparams{
                        width = wrapContent
                        height = wrapContent
                        below(R.id.sourcecard_description)
                    }


                    textView {
                        id = R.id.sourcecard_lang
                        text = "Language"
                        padding = dip(5)
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                        baselineOf(R.id.sourcecard_category)
                        bottomOf(R.id.sourcecard_category)
                        alignParentRight()
                        alignParentEnd()
                    }
                }
            }
        }
    }

}