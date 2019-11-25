package com.example.vinod.newsapp.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vinod.newsapp.base.utils.schedulers.BaseSchedulerProvider
import com.example.vinod.newsapp.model.News
import com.example.vinod.newsapp.repository.NewsRepository
import javax.inject.Inject

class NewsViewModel @Inject constructor(
  private val newsRepository: NewsRepository, private val scheduler: BaseSchedulerProvider
) : ViewModel() {

  var mNewsDateResponse: MutableLiveData<News> = MutableLiveData()

  @SuppressLint("CheckResult") fun initNewsApiCall() {
    newsRepository.callNewsApi().subscribeOn(scheduler.io()).observeOn(scheduler.ui())
      .doOnError { error ->
        getNewsErrorResponse(error)
      }.subscribe({ getNewsResponse(it) }, {})
  }

  private fun getNewsErrorResponse(error: Throwable) {

  }

  private fun getNewsResponse(news: News) {
    mNewsDateResponse.value = news
  }


}