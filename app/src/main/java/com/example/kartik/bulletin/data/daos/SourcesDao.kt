package com.example.kartik.bulletin.data.daos

import android.arch.persistence.room.*
import com.example.kartik.bulletin.Model
import com.example.kartik.bulletin.NewsApiService
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Dao
public interface SourcesDao{

    @Query("SELECT * FROM Sources")
    fun getAllSources(): Single<List<Model.Source>>

    @Query("DELETE FROM Sources")
    fun deleteAllSources()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllSources(sources : List<Model.Source>)

}