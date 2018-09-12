package com.example.kartik.bulletin.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.kartik.bulletin.data.entitity.Source

@Dao
interface SourcesDao{

    @Query("SELECT * FROM Source")
    fun getAllSources(): LiveData<List<Source>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllSources(sources : ArrayList<Source>)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertSingle(source : Source)

    @Query("UPDATE Source SET favourite = 1 WHERE id = :id")
    fun addFavourite(id:String)

    @Query("UPDATE Source SET favourite = 0 WHERE id = :id")
    fun deleteFavourite(id:String)

    @Query("DELETE FROM Source")
    fun deleteAll()
}