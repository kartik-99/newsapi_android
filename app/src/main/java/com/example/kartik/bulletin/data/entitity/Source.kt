package com.example.kartik.bulletin.data.entitity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Source(
        @PrimaryKey
        val id:String,
        val name:String,
        val description:String,
        val url:String,
        val category:String,
        val language:String,
        val country:String,
        val favourite:Int?=0
)