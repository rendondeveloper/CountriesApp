package com.rendonsoft.testtotalplay.utils.extensions

import android.util.Log
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso

fun String.log(){
    Log.d("TestElektra", "- $this")
}

fun ImageView.loadUrl(url : String, @DrawableRes placeholder: Int?=null){
    placeholder?.let {
        Picasso
            .get()
            .load(url)
            .placeholder(it)
            .into(this)
    }?: kotlin.run {
        Picasso
            .get()
            .load(url)
            .into(this)
    }
}
