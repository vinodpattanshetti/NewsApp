package com.example.vinod.newsapp.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vinod.newsapp.R
import com.example.vinod.newsapp.base.utils.MyBounceInterpolator
import com.example.vinod.newsapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

  private var mAnimUpDown: Animation? = null
  private lateinit var mBinder: ActivitySplashBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinder = DataBindingUtil.setContentView(this, R.layout.activity_splash)
    initAnimation()
    openHomeScreenImage()
  }

  private fun initAnimation() {
    mAnimUpDown = AnimationUtils.loadAnimation(
      this, R.anim.rotate_animation
    )
    val mInterpolator = MyBounceInterpolator(0.2, 10.0)
    mAnimUpDown?.interpolator = mInterpolator
    mBinder.ivImage.startAnimation(mAnimUpDown)
  }

  private fun openHomeScreenImage() {
    val splashTimeOut = 2000
    Handler().postDelayed({
      val intent = Intent(this@SplashActivity, NewsActivity::class.java)
      startActivity(intent)
      mAnimUpDown?.cancel()
      finish()
    }, splashTimeOut.toLong())
  }


}
