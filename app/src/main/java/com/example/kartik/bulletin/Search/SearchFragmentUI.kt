package com.example.kartik.bulletin.Search

import com.example.kartik.bulletin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.searchView
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.recyclerview.v7.recyclerView

class SearchFragmentUI<T> : AnkoComponent<T> {
    override fun createView(ui: AnkoContext<T>) = with(ui){

        relativeLayout {
            searchView { id = R.id.searchview }.lparams{
                width = matchParent
                height = wrapContent
            }

            recyclerView {
                id = R.id.search_results_rv
            }.lparams{
                width = matchParent
                height = matchParent
                below(R.id.searchview)
            }
        }


    }

}