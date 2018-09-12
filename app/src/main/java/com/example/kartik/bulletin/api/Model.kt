package com.example.kartik.bulletin.api

import com.example.kartik.bulletin.data.entitity.Source

object Model{

    data class SourceData(
            val status: String,
            val sources: ArrayList<Source>
    )
//
//    data class Source(
//            val id:String,
//            val name: String,
//            val description: String,
//            val url: String,
//            val category : String,
//            val language : String,
//            val country : String,
//            val favourite:Int? = 0
//    )

}