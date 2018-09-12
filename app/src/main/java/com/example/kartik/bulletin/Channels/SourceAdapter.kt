package com.example.kartik.bulletin.Channels

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.R
import com.example.kartik.bulletin.data.entitity.Source
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import java.util.*

class SourceAdapter(val sources : ArrayList<Source>) : RecyclerView.Adapter<SourceAdapter.SourceViewHolder>(){

    var storedSources = sources

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        var view = SourceCard_UI<SourceAdapter>().createView(AnkoContext.create(parent.context, this))
        return SourceViewHolder(view)
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.updateUI(this.storedSources[position])
    }

    override fun getItemCount(): Int { return this.storedSources.size}

    fun updateSources(sources : List<Source>){
        this.storedSources = sources as ArrayList<Source>
    }


    class SourceViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var title : TextView = itemView!!.find(R.id.sourcecard_title)
        var description: TextView = itemView!!.find(R.id.sourcecard_description)
        var language: TextView = itemView!!.find(R.id.sourcecard_lang)
        var categoryColor: ImageView = itemView!!.find(R.id.sourcecard_category_imageview)

        fun updateUI(source : Source){
            title.text = source.name
            description.text = source.description
            language.text = source.language

            when(source.language){
                "de"-> language.text = "German"
                "en"-> language.text = "English"
                "es"-> language.text = "Spanish"
                "fr"-> language.text = "French"
                "he"-> language.text = "Hebrew"
                "it"-> language.text = "Italian"
                "nl"-> language.text = "Dutch"
                "no"-> language.text = "Norwegian"
                "pt"-> language.text = "Portuguese"
                "ru"-> language.text = "Russian"
                "se"-> language.text = "Northern Sami"
                "ud"-> language.text = "ud"
                "zh"-> language.text = "Chinese"


            }
        }
    }

}