package com.example.kartik.bulletin.data.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.kartik.bulletin.Model
import com.example.kartik.bulletin.NewsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.List

@Dao
public interface SourcesDao{

    @Query("SELECT * FROM Sources")
    fun getAllSources(): List<Model.Source>

    @Query("DELETE FROM Sources")
    fun deleteAllSources()

    @Insert
    fun addAllSources(sources : List<Model.Source>)

}