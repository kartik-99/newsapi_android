package com.example.kartik.bulletin.api

object Model{

    //SOURCES
    data class SourceData(
            val status: String,
            val sources: ArrayList<Source>
    )

    data class Source(
            val id:String,
            val name: String,
            val description: String,
            val url: String,
            val category : String,
            val language : String,
            val country : String
    )

    //ARTICLES
    data class ArticleData(
            val status:String,
            val totalResults:Long,
            val articles:ArrayList<Article>
    )

    data class Article(
            val source:ArticleSource,
            val author:String,
            val title:String,
            val description:String,
            val url:String,
            val urlToImage:String,
            val publishedAt:String
    )


    data class ArticleSource(
            val id:String,
            val name:String
    )
}