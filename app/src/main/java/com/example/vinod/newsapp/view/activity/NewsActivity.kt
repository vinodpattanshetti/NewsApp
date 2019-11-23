package com.example.vinod.newsapp.view.activity

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.vinod.newsapp.R
import com.example.vinod.newsapp.databinding.ActivityMainBinding
import com.example.vinod.newsapp.viewmodel.NewsViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class NewsActivity : AppCompatActivity() {

  private var mBinder: ActivityMainBinding? = null
  @Inject lateinit var mViewModel: ViewModelProvider.Factory
  lateinit var mWeatherViewModel: NewsViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinder = DataBindingUtil.setContentView(this, R.layout.activity_main)
    AndroidInjection.inject(this)
    mWeatherViewModel = ViewModelProviders.of(this, mViewModel).get(NewsViewModel::class.java)
    mWeatherViewModel.initNewsApiCall()
    initViews()
  }

  private fun initViews() {
    mWeatherViewModel.mNewsDateResponse.observe(this, Observer {
      Log.e("", it.toString())
    })
  }
}
