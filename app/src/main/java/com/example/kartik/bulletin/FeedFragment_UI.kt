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
            textView {
                text = "News Feed\nComing Soon :)"
                gravity = Gravity.CENTER
            }.lparams(width = matchParent, height = matchParent)
        }
    }
}