package com.example.vinod.newsapp.base.utils

class MyBounceInterpolator(private val mAmplitude: Double, private val mFrequency: Double) :
  android.view.animation.Interpolator {

  override fun getInterpolation(time: Float): Float {
    return (-1.0 * Math.pow(Math.E, -time / mAmplitude) * Math.cos(mFrequency * time) + 1).toFloat()
  }
}