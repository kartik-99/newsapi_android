package com.example.kartik.bulletin.architecture

import android.arch.lifecycle.ViewModel
import com.example.kartik.bulletin.Model
import com.example.kartik.bulletin.data.daos.SourcesDao
import io.reactivex.Single

class AviewModel(private val dataSource: SourcesDao) :ViewModel() {

    fun getSources() : Single<List<Model.Source>>{
        return dataSource.getAllSources()
    }

    fun updateSources(sources : List<Model.Source>){
        return dataSource.addAllSources(sources)
    }

}