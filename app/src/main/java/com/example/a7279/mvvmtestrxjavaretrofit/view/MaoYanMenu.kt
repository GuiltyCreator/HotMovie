package com.example.a7279.mvvmtestrxjavaretrofit.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.example.a7279.mvvmtestrxjavaretrofit.R
import com.example.a7279.mvvmtestrxjavaretrofit.databinding.ActivityMaoYanMenuBinding
import com.example.a7279.mvvmtestrxjavaretrofit.model.remote.MovieService
import com.example.a7279.mvvmtestrxjavaretrofit.viewmodel.MovieViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MaoYanMenu : AppCompatActivity() {

    lateinit var mBinding:ActivityMaoYanMenuBinding
    lateinit var mViewModel:MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding=DataBindingUtil.setContentView(this,R.layout.activity_mao_yan_menu)

       val remote=Retrofit.Builder()
            .baseUrl("https://api-m.mtime.cn/PageSubArea/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)

        mViewModel=MovieViewModel(this,remote)
        mBinding.vm=mViewModel
    }
}
