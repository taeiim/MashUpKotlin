package com.taeiim.gittoy.binding

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

@BindingAdapter("loadUrl")
fun ImageView.loadUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .transform(RoundedCorners(8))
        .into(this)
}
