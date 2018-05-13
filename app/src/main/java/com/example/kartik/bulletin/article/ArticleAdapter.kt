package com.example.kartik.bulletin.article

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kartik.bulletin.R
import com.example.kartik.bulletin.api.Model
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class ArticleAdapter(val articles : ArrayList<Model.Article>, val context: Context) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        var view = ArticleUI<ArticleAdapter>().createView(AnkoContext.create(context, this))
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.updateUI(articles[position], context)
    }

    override fun getItemCount(): Int {return articles.size}


    class ArticleViewHolder(itemView:View?): RecyclerView.ViewHolder(itemView) {
        var title : TextView = itemView!!.find(R.id.article_title)
        var description : TextView = itemView!!.find(R.id.article_description)
        var author : TextView = itemView!!.find(R.id.article_author)
        var date : TextView = itemView!!.find(R.id.article_date)
        var image : ImageView = itemView!!.find(R.id.article_image)
        //var progressbar : ProgressBar = itemView!!.find(R.id.article_progressbar)

        fun updateUI(article : Model.Article, context: Context){
            title.text = article.title
            description.text = article.description
            author.text = article.author
            date.text = article.publishedAt
            Glide.with(context).load(article.urlToImage).into(image)
        }
    }
}