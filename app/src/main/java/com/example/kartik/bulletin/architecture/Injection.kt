package com.example.kartik.bulletin.architecture

import android.content.Context
import com.example.kartik.bulletin.data.daos.SourcesDao


object Injection{
    fun provideSourcesData(context : Context): SourcesDao{
        val database = AppDatabase.getInstance(context)
        return database.sourcesDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideSourcesData(context)
        return ViewModelFactory(dataSource)
    }

}