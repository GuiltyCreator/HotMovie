package com.example.a7279.mvvmtestrxjavaretrofit.model.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.a7279.mvvmtestrxjavaretrofit.model.data.Movy
import com.example.a7279.mvvmtestrxjavaretrofit.model.local.dao.MovyDao

@Database(entities = arrayOf(Movy::class),version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun  MovyDao():MovyDao
    companion object {
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "app.db")
                .allowMainThreadQueries()
                .build()
        @Volatile private var INSANCE:AppDatabase? = null
        fun getInstance(context: Context):AppDatabase= INSANCE ?: synchronized(this){
            INSANCE ?: buildDatabase(context).also { INSANCE = it }
        }
    }
}