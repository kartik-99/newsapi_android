package com.example.kartik.bulletin.Channels


import android.graphics.Color
import com.example.kartik.bulletin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class ChannelsFragmentUI<T> : AnkoComponent<T>{
    override fun createView(ui: AnkoContext<T>) = with(ui){
        relativeLayout {
            lparams{
                width = matchParent
                height = matchParent
            }
            toolbar {
                id = R.id.channels_toolbar
                title = "Channels"
                setTitleTextColor(Color.WHITE)
                alpha = 1f
                backgroundColorResource = R.color.colorPrimary
            }.lparams{
                width = matchParent
                height = wrapContent
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
                below(R.id.channels_toolbar)
            }


        }
    }

}