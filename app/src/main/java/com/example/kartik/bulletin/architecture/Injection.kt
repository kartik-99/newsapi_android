package com.example.kartik.bulletin.architecture

import android.content.Context
import com.example.kartik.bulletin.data.BulletinDb
import com.example.kartik.bulletin.data.dao.SourcesDao


object Injection{
    fun provideSourcesData(context : Context): SourcesDao{
        val database = BulletinDb.get(context)
        return database.sourcesDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideSourcesData(context)
        return ViewModelFactory(dataSource)
    }

}