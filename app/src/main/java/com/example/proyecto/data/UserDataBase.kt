package com.example.proyecto.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proyecto.model.User


@Database(entities=[User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase(){
    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getDatabase(context: android.content.Context) : UserDataBase {
            val temp = INSTANCE
            if (temp!=null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "UserDataBase"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}