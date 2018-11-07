package com.example.a7279.mvvmtestrxjavaretrofit.model.repository

import com.example.a7279.mvvmtestrxjavaretrofit.model.data.Movy
import com.example.a7279.mvvmtestrxjavaretrofit.model.local.dao.MovyDao
import com.example.a7279.mvvmtestrxjavaretrofit.model.remote.MovieService

class MovieRepo constructor(private val local:MovyDao){

    fun setMovies(list: List<Movy>) {
        local.deleteMovies(local.queryAllMovies())
        local.insertMovies(list)
    }
    fun getLocalMovies()=local.queryAllMovies()
}