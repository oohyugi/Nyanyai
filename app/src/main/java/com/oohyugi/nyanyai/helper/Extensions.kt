package com.oohyugi.nyanyai.helper

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.oohyugi.nyanyai.R
import com.squareup.picasso.Picasso

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.with(context).load(imageUrl).resize(300,300).centerCrop().into(this)
    }
}fun ImageView.loadImgDetail(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.with(context).load(imageUrl).fit().centerCrop().into(this)
    }
}

