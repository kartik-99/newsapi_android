package com.example.kartik.bulletin.architecture

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.data.dao.SourcesDao
import com.example.kartik.bulletin.data.entitity.Source

class AviewModel(private val dataSource: SourcesDao) :ViewModel() {

    fun getSources() : LiveData<List<Source>> {
        return dataSource.getAllSources()
    }

    fun updateSources(sources : List<Source>){
        return dataSource.addAllSources(sources as ArrayList<Source>











        )
    }

}