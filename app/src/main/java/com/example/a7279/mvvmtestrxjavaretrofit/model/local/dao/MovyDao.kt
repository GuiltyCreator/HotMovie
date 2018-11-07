package com.example.a7279.mvvmtestrxjavaretrofit.model.local.dao

import android.arch.persistence.room.*
import com.example.a7279.mvvmtestrxjavaretrofit.model.data.Movy

@Dao
interface MovyDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<Movy>)

    @Delete()
    fun deleteMovies(list: List<Movy>)

    @Query("SELECT * FROM movy")
    fun queryAllMovies():List<Movy>

}