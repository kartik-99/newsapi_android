package com.example.kartik.bulletin.Search

import android.graphics.Color
import com.example.kartik.bulletin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.searchView
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.custom.style
import org.jetbrains.anko.recyclerview.v7.recyclerView

class SearchFragmentUI<T> : AnkoComponent<T> {
    override fun createView(ui: AnkoContext<T>) = with(ui){

        verticalLayout {

            toolbar {
                id = R.id.search_toolbar
                backgroundColorResource = R.color.colorPrimary
                linearLayout {
                    lparams{
                        width = matchParent
                        height = matchParent
                    }
                    searchView {
                        id = R.id.searchview
                        setIconifiedByDefault(false)
                    }.lparams{
                        width = matchParent
                        height = wrapContent
                    }
                }

            }.lparams{
                width = matchParent
                height = wrapContent
            }

            recyclerView {
                id = R.id.search_results_rv
            }.lparams{
                width = matchParent
                height = matchParent
            }
        }


    }

}