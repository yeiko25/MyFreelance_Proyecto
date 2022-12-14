package com.example.proyecto.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proyecto.model.Service

@Database(entities=[Service::class], version = 1, exportSchema = false)
abstract class ServiceDataBase : RoomDatabase(){
    abstract fun serviceDao() : ServiceDao

    companion object {
        @Volatile
        private var INSTANCE: ServiceDataBase? = null

        fun getDatabase(context: android.content.Context) : ServiceDataBase {
            val temp = INSTANCE
            if (temp!=null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ServiceDataBase::class.java,
                    "ServiceDataBase"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}