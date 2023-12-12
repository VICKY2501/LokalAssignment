package com.example.lokalassignment.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imageurl")
    fun imageurl(view: ImageView,url:String?)
    {
         url?.let{
             Picasso.get().load(url).into(view);
         }
    }
}