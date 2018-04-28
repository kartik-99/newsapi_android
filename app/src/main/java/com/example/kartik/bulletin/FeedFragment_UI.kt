package com.example.kartik.bulletin

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class FeedFragment_UI<T>:AnkoComponent<T>{
    override fun createView(ui: AnkoContext<T>) = with(ui){
        verticalLayout{
//            textView {
//                text = "News Feed\n(Coming Soon)"
//                gravity = Gravity.CENTER
//            }.lparams(width = matchParent, height = matchParent)
//
            cardView {
                verticalLayout {
                    textView {text = "Title"}.lparams(width = wrapContent, height = wrapContent)
                    textView {text = "Description"}.lparams(width = wrapContent, height = wrapContent)
                    textView {text = "Category"}.lparams(width = wrapContent, height = wrapContent)
                    textView {text = "Language"}.lparams(width = wrapContent, height = wrapContent)
                    textView {text = "Country"}.lparams(width = wrapContent, height = wrapContent)
                }.lparams(width = matchParent, height = matchParent)
            }.lparams(width = wrapContent, height = wrapContent)
        }
    }
}