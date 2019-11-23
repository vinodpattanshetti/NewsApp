package com.example.vinod.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vinod.newsapp.base.utils.getError
import com.example.vinod.newsapp.base.utils.schedulers.BaseSchedulerProvider
import com.example.vinod.newsapp.model.News
import com.example.vinod.newsapp.repository.NewsRepository
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository,
  private val scheduler: BaseSchedulerProvider
) : ViewModel() {

  var mNewsDateResponse: MutableLiveData<News> = MutableLiveData()
  var isError: MutableLiveData<Boolean> = MutableLiveData()

  fun initNewsApiCall() {
    newsRepository.callNewsApi().subscribeOn(scheduler.io()).observeOn(scheduler.ui()).doOnError {
      error -> getNewsResponse(error.getError())
    }.subscribe({getNewsResponse(it.getResult(it))}, {})
  }

  private fun getNewsResponse(mResult: com.example.vinod.newsapp.model.Result<News>) {
    when (mResult) {
      is com.example.vinod.newsapp.model.Result.Success -> {
        mNewsDateResponse.value = mResult.data
      }
      is com.example.vinod.newsapp.model.Result.Error -> {
        isError.value = true
      }
    }
  }

}