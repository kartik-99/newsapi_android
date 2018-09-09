package com.example.kartik.bulletin.data.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.data.sourceTableName
import io.reactivex.Single

@Dao
interface SourcesDao{

    @Query("SELECT * FROM Sources")
    fun getAllSources(): LiveData<List<Model.Source>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllSources(sources : ArrayList<Model.Source>)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertSingle(source : Model.Source)

    @Query("UPDATE "+ sourceTableName + " SET favourite = 1 WHERE id = :id")
    fun addFavourite(id:String)

    @Query("UPDATE "+ sourceTableName + " SET favourite = 0 WHERE id = :id")
    fun deleteFavourite(id:String)
}