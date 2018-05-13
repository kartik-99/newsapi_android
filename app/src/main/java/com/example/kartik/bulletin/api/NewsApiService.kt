package com.example.kartik.bulletin.api


import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface NewsApiService{


    @GET("sources")
    fun getSources(@Query("category")category:String,
                   //@Query("language")language:String,
                   //@Query("country")country:String,
                   @Query("apiKey")apiKey:String):Observable<Model.SourceData>

    @GET("everything")
    fun getSearchResult(@Query("q")searchString: String,
                        @Query("apiKey")apiKey:String):Observable<Model.ArticleData>


    companion object {
        fun create(): NewsApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://newsapi.org/v2/")
                    .client(client)
                    .build()

            return retrofit.create(NewsApiService::class.java)
        }
    }
}