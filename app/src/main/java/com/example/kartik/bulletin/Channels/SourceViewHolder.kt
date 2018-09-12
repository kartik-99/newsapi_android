package com.example.kartik.bulletin.Channels

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.kartik.bulletin.R
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.data.entitity.Source
import org.jetbrains.anko.AnkoContext

class SourceViewHolder(parent:ViewGroup):RecyclerView.ViewHolder(
        (LayoutInflater.from(parent.context).inflate(R.layout.card_source, parent, false))) {

    private val title = itemView.findViewById<TextView>(R.id.source_title)
    private val description = itemView.findViewById<TextView>(R.id.source_description)
    private val category = itemView.findViewById<TextView>(R.id.source_category)
    var source: Source? = null

    fun bindTo(source: Source){
        this.source = source
        title.text = source.name
        description.text = source.description
        category.text = source.category
    }
}