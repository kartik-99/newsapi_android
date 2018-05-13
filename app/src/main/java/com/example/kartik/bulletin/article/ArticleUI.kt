package com.example.kartik.bulletin.article

import android.graphics.Color
import com.example.kartik.bulletin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class ArticleUI <T>:AnkoComponent<T>{
    override fun createView(ui: AnkoContext<T>) = with(ui){
        relativeLayout {
            lparams{
                width = matchParent
                height = wrapContent
            }

            cardView {
                isClickable = true
                lparams{
                    width = matchParent
                    height = wrapContent
                    margin = dip(5)
                }

                relativeLayout {
                    lparams{
                        width = matchParent
                        height = matchParent
                    }

                    /*progressBar {
                        id = R.id.article_progressbar
                    }.lparams{
                        width = matchParent
                        height = wrapContent
                    }*/

                    imageView {
                        id = R.id.article_image
                        adjustViewBounds = true
                    }.lparams{
                        width = matchParent
                        height = wrapContent
                        below(R.id.article_progressbar)
                    }

                    textView {
                        id = R.id.article_description
                    }.lparams{
                        width = matchParent
                        height = wrapContent
                        margin = dip(2)
                        below(R.id.article_image)
                        setPadding(5, 0, 5, 0)
                    }

                    textView {
                        id = R.id.article_author
                    }.lparams{
                        width = wrapContent
                        height = wrapContent
                        below(R.id.article_description)
                        setPadding(5,0,0,0)
                    }

                    textView {
                        id = R.id.article_date

                    }.lparams{
                        width = wrapContent
                        height = wrapContent
                        margin = dip(2)
                        below(R.id.article_description)
                        alignParentRight()
                        alignParentEnd()
                        setPadding(0, 0, 5, 0)
                    }

                    textView {
                        id = R.id.article_title
                        textColor = Color.WHITE
                        backgroundColor = R.color.articleTitleBackground
                        textSize = 18f
                    }.lparams{
                        width = matchParent
                        height = wrapContent
                        above(R.id.article_description)
                        alignParentLeft()
                        alignParentStart()
                        setPadding(5, 0, 5, 0)
                    }
                }
            }


        }
    }

}