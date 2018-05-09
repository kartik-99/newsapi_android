import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.kartik.bulletin.data.daos.SourcesDao
import com.example.kartik.bulletin.data.entities.Sources

@Database(entities = [(Sources::class)], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract fun sourcesDao():SourcesDao

    companion object {
        private var appDatabase:AppDatabase? = null

        @Synchronized
        fun getInstance(context:Context):AppDatabase{
            if(appDatabase==null){
                appDatabase = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "example.db")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return appDatabase!!
        }
    }
}