package com.example.vinod.newsapp.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinod.newsapp.R
import com.example.vinod.newsapp.base.utils.SpacesItemDecoration
import com.example.vinod.newsapp.databinding.ActivityMainBinding
import com.example.vinod.newsapp.model.Article
import com.example.vinod.newsapp.model.News
import com.example.vinod.newsapp.view.adapter.NewsListingAdapter
import com.example.vinod.newsapp.viewmodel.NewsViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class NewsActivity : AppCompatActivity(), NewsListingAdapter.IActivityCommunicator {
  private var mBinder: ActivityMainBinding? = null
  @Inject lateinit var mViewModel: ViewModelProvider.Factory
  private lateinit var mWeatherViewModel: NewsViewModel
  private var mNews: News? = null

  companion object {
    const val ARTICLE_DATA = "ARTICLE_DATA"
  }

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
      mNews = it
      initNewsListAdapter()
    })
  }

  private fun initNewsListAdapter() {
    mBinder?.rvNewsList?.layoutManager = LinearLayoutManager(this)
    mBinder?.rvNewsList?.addItemDecoration(SpacesItemDecoration(32))
    mBinder?.rvNewsList?.itemAnimator = DefaultItemAnimator()
    val newsAdapter = NewsListingAdapter(mNews, this)
    mBinder?.rvNewsList?.adapter = newsAdapter
  }

  override fun onItemSelected(article: Article?, position: Int) {
    val intent = Intent(this, NewsDetailActivity::class.java)
    intent.putExtra(ARTICLE_DATA, article)
    startActivity(intent)
  }
}
