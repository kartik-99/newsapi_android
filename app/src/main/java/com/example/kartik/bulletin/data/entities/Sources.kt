package com.example.kartik.bulletin.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
public class Sources(
        @PrimaryKey
        val id:String,
        val name:String,
        val description:String,
        val url:String,
        val category:String,
        val language:String,
        val country:String
)