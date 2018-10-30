package com.example.a7279.mvvmtestrxjavaretrofit.util


import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class CustomAppGlideModule:AppGlideModule(){
}



object BindingAdapter{

    @BindingAdapter("app:imageUrl")
    @JvmStatic fun loadImage(iv: ImageView, pic: String) {
        GlideApp.with(iv).load(pic).into(iv)
    }

}