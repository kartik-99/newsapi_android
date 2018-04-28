package com.example.kartik.bulletin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class SourceAdapter(val sources : ArrayList<Model.Source>) : RecyclerView.Adapter<SourceAdapter.SourceViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        var view = SourceCard_UI<SourceAdapter>().createView(AnkoContext.create(parent.context, this))
        return SourceViewHolder(view)
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.updateUI(sources[position])
    }

    override fun getItemCount(): Int { return sources.size}


    class SourceViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var title : TextView = itemView!!.find(R.id.sourcecard_title)
        var description: TextView = itemView!!.find(R.id.sourcecard_description)
        var category: TextView = itemView!!.find(R.id.sourcecard_category)
        var language: TextView = itemView!!.find(R.id.sourcecard_lang)

        fun updateUI(source : Model.Source){
            title.text = source.name
            description.text = source.description
            category.text = source.category
            language.text = source.language
        }
    }

}