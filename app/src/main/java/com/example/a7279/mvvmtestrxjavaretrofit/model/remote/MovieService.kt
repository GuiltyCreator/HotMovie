package com.example.a7279.mvvmtestrxjavaretrofit.model.remote

import com.example.a7279.mvvmtestrxjavaretrofit.model.data.MovieBean
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService{
    @GET("HotPlayMovies.api")
   fun getHotMovie(@Query("locationId") locationId:Int):Single<MovieBean>
}