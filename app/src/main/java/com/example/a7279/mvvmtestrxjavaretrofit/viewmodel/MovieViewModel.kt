package com.example.a7279.mvvmtestrxjavaretrofit.viewmodel

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.a7279.mvvmtestrxjavaretrofit.Adapter.DataBindingRecyclerViewAdapter
import com.example.a7279.mvvmtestrxjavaretrofit.BR
import com.example.a7279.mvvmtestrxjavaretrofit.R
import com.example.a7279.mvvmtestrxjavaretrofit.model.data.MovieBean
import com.example.a7279.mvvmtestrxjavaretrofit.model.data.Movy
import com.example.a7279.mvvmtestrxjavaretrofit.model.remote.MovieService
import com.example.a7279.mvvmtestrxjavaretrofit.model.repository.MovieRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_mao_yan_menu.*


class MovieViewModel(private val activity:Activity,private val remote:MovieService,private val repo:MovieRepo){
    var adapter:DataBindingRecyclerViewAdapter?=null
     var mlist:MutableList<Movy>

    init {

       mlist= mutableListOf()


        remote.getHotMovie(290)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ m :MovieBean ->
                repo.setMovies(m.movies)
                println("加载了:${m.movies}")
                mlist.addAll(m.movies)
                adapter= DataBindingRecyclerViewAdapter(activity,R.layout.itemlayout,BR.m,mlist)
                activity.movielist.layoutManager=LinearLayoutManager(activity.application,LinearLayoutManager.VERTICAL,false)
                activity.movielist.adapter=adapter
                activity.movielist.adapter.notifyDataSetChanged()

            },{
                println("网络错误，加载数据库数据")
                mlist.addAll(repo.getLocalMovies())
                adapter= DataBindingRecyclerViewAdapter(activity,R.layout.itemlayout,BR.m,mlist)
                activity.movielist.layoutManager=LinearLayoutManager(activity.application,LinearLayoutManager.VERTICAL,false)
                activity.movielist.adapter=adapter
                activity.movielist.adapter.notifyDataSetChanged()
            })
        println("mlist:"+mlist)
    }

    fun log(){
        println("log mlist:"+mlist)
        mlist.addAll(mlist)
        activity.movielist.adapter.notifyDataSetChanged()
    }
}