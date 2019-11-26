package com.example.vinod.newsapp.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vinod.newsapp.base.NewsApplication
import com.example.vinod.newsapp.base.utils.OpenForTesting
import com.example.vinod.newsapp.base.utils.schedulers.BaseSchedulerProvider
import com.example.vinod.newsapp.model.News
import com.example.vinod.newsapp.repository.NewsRepository
import javax.inject.Inject

@OpenForTesting
open class NewsViewModel @Inject constructor(
  private val newsRepository: NewsRepository, private val scheduler: BaseSchedulerProvider
) : ViewModel() {

  var mNewsDateResponse: MutableLiveData<News> = MutableLiveData()

  @SuppressLint("CheckResult") fun initNewsApiCall() {
    newsRepository.callNewsApi().subscribeOn(scheduler.io()).observeOn(scheduler.ui())
      .doOnError { _ ->
        getNewsErrorResponse()
      }.subscribe({ getNewsResponse(it) }, {})
  }

  private fun getNewsErrorResponse() {
    val mNews = News()
    mNews.isError = true
    mNewsDateResponse.value = mNews
  }

  private fun getNewsResponse(news: News) {
    mNewsDateResponse.value = news
  }
}