package com.example.kartik.bulletin.Channels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.kartik.bulletin.R
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.api.NewsApiService
import com.example.kartik.bulletin.data.BulletinDb
import com.example.kartik.bulletin.data.entitity.Source
import com.example.kartik.bulletin.ioThread
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SourceViewModel(application: Application):AndroidViewModel(application) {

    var sourceList : LiveData<List<Source>>
    var db : BulletinDb
    var apiDisposable: Disposable?= null
    private var newsApiService = NewsApiService.create()

    init {
        db = BulletinDb.get(this.getApplication())
        sourceList = db.sourcesDao(). getAllSources()
        var test = sourceList.value
        if(test?.size==1 || test==null)
            updateSourcesTable()
    }

    fun getSources():LiveData<List<Source>> {return sourceList}

    fun updateSourcesTable() {

        val apiKey = getApplication<Application>().resources.getString(R.string.apiKey)
        apiDisposable = newsApiService.getSources("", apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ data: Model.SourceData? ->
                    ioThread {
                        db.sourcesDao().addAllSources(data!!.sources)
                    }
                }
    }
}