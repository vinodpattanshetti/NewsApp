package com.example.vinod.newsapp.base.utils

import android.annotation.SuppressLint
import android.view.View
import java.text.SimpleDateFormat

const val NETWORK_TIMEOUT_IN_SECONDS = 60L
const val NETWORK_CACHE_SIZE = 10 * 1024 * 1024L
const val CELSIUS_KEY = "C"

fun View.showView() {
  this.visibility = View.VISIBLE
}

fun View.hideView() {
  this.visibility = View.GONE
}
