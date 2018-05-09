package com.example.kartik.bulletin.data.daos

import android.arch.persistence.room.*
import com.example.kartik.bulletin.api.Model
import io.reactivex.Single

@Dao
public interface SourcesDao{

    @Query("SELECT * FROM Sources")
    fun getAllSources(): Single<List<Model.Source>>

    @Query("DELETE FROM Sources")
    fun deleteAllSources()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllSources(sources : List<Model.Source>)

}