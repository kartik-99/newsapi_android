package com.example.kartik.bulletin


import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ChannelsFragment_UI<T> : AnkoComponent<T>{
    override fun createView(ui: AnkoContext<T>) = with(ui){
        relativeLayout {
            lparams{
                width = matchParent
                height = matchParent
            }

            recyclerView {
                lparams{
                    width = matchParent
                    height = matchParent
                }
                id = R.id.recyclerview_all_sources
            }
        }
    }

}