package com.example.vinod.newsapp.base.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.vinod.newsapp.R

const val NETWORK_TIMEOUT_IN_SECONDS = 60L
const val NETWORK_CACHE_SIZE = 10 * 1024 * 1024L
const val CELSIUS_KEY = "C"

fun View.showView() {
  this.visibility = View.VISIBLE
}

fun View.hideView() {
  this.visibility = View.GONE
}

fun Int?.orDefaultInt() = this ?: 0

fun String?.orDefault(default: String): String {
  return if (!this.isNullOrEmpty()) this else default
}

fun returnRequiredDate(date: String?): String {
  return date?.split("T")?.get(0).orEmpty()
}

fun setImageLoader(imageView: ImageView, url: String) {
  Glide.with(imageView.context).load(url).apply(RequestOptions.placeholderOf(R.color.colorPrimary))
    .into(imageView)
}
