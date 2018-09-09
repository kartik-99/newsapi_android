package com.example.kartik.bulletin.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.kartik.bulletin.api.Model
import com.example.kartik.bulletin.data.daos.SourcesDao
import com.example.kartik.bulletin.ioThread

@Database(entities = arrayOf(Model.Source::class), version = 1)
abstract class BulletinDb : RoomDatabase() {
    abstract fun sourcesDao() : SourcesDao

    companion object {
        private var instance: BulletinDb? = null
        @Synchronized
        fun get(context: Context): BulletinDb {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        BulletinDb::class.java, "CheeseDatabase")
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                fillInDb(context.applicationContext)
                            }
                        }).build()
            }
            return instance!!
        }
        fun fillInDb(context: Context){
            ioThread {
                get(context).sourcesDao().insertSingle(Model.Source("00", "", "", "", "", "", ""))
            }
        }
    }
}
