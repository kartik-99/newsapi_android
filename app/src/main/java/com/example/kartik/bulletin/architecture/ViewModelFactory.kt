package com.example.kartik.bulletin.architecture

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.kartik.bulletin.data.daos.SourcesDao

class ViewModelFactory(private val dataSource: SourcesDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AviewModel::class.java))
            return AviewModel(dataSource) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }

}