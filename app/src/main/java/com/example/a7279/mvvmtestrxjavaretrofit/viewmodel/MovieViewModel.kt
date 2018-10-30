package com.example.a7279.mvvmtestrxjavaretrofit.viewmodel

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import com.example.a7279.mvvmtestrxjavaretrofit.Adapter.DataBindingRecyclerViewAdapter
import com.example.a7279.mvvmtestrxjavaretrofit.BR
import com.example.a7279.mvvmtestrxjavaretrofit.R
import com.example.a7279.mvvmtestrxjavaretrofit.model.data.MovieBean
import com.example.a7279.mvvmtestrxjavaretrofit.model.data.Movy
import com.example.a7279.mvvmtestrxjavaretrofit.model.remote.MovieService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_mao_yan_menu.*


class MovieViewModel(val activity:Activity,remote:MovieService){
    var adapter:DataBindingRecyclerViewAdapter?=null
     var mlist:MutableList<Movy>

    init {
        mlist= mutableListOf()

        remote.getHotMovie(290)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ m :MovieBean ->
                mlist.addAll(m.movies)
                adapter= DataBindingRecyclerViewAdapter(activity,R.layout.itemlayout,BR.m,mlist)
                activity.movielist.layoutManager=LinearLayoutManager(activity.application,LinearLayoutManager.VERTICAL,false)
                activity.movielist.adapter=adapter
                activity.movielist.adapter.notifyDataSetChanged()

            }
        println("mlist:"+mlist)
    }

    fun log(){
        println("mlist1:"+mlist)
        mlist.addAll(mlist)
        activity.movielist.adapter.notifyDataSetChanged()
    }
}