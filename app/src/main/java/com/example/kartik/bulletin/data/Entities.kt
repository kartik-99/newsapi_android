package com.example.kartik.bulletin.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

const val sourceTableName = "sources"
@Entity(tableName = sourceTableName)
public class Sources(
        @PrimaryKey
        val id:String,
        val name:String,
        val description:String,
        val url:String,
        val category:String,
        val language:String,
        val country:String,
        val favourite:Int
)