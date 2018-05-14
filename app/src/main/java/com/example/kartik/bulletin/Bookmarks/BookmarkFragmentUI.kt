package com.example.kartik.bulletin.Bookmarks

import android.graphics.Color
import android.view.Gravity
import com.example.kartik.bulletin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar

class BookmarkFragmentUI<T>: AnkoComponent<T> {
    override fun createView(ui: AnkoContext<T>) = with(ui){
        verticalLayout{
            toolbar {
                id = R.id.bookmark_toolbar
                title = "Bookmarks"
                setTitleTextColor(Color.WHITE)
                //alpha = 1f
                backgroundColorResource = R.color.colorPrimary
            }.lparams{
                width = matchParent
                height = wrapContent
            }

            textView {
                text = "Bookmarks\nComing Soon :)"
                gravity = Gravity.CENTER
            }.lparams{
                width = matchParent
                height = matchParent
            }
        }
    }
}