package com.example.strongheart.kedditapp.commons.extensions

import android.net.Uri
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.strongheart.kedditapp.R
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    Picasso.with(context).setLoggingEnabled(true)
    if(TextUtils.isEmpty(imageUrl)) {
        this.setImageResource(R.mipmap.ic_launcher)
    } else {
        Picasso.with(context).load(imageUrl).into(this)
    }
}