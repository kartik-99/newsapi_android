package com.example.kartik.bulletin.Channels


import com.example.kartik.bulletin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class SourceFragment_UI<T> : AnkoComponent<T>{
    override fun createView(ui: AnkoContext<T>) = with(ui){
        relativeLayout {
            lparams{
                width = matchParent
                height = matchParent
            }
            swipeRefreshLayout {
                id = R.id.swipe_layout

                recyclerView {
                    lparams{
                        width = matchParent
                        height = matchParent
                    }
                    id = R.id.recyclerview_all_sources
                }
            }.lparams{
                width = matchParent
                height = matchParent
            }


        }
    }

}