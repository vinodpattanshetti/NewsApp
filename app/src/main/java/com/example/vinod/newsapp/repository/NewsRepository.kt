package com.example.vinod.newsapp.repository

import com.example.vinod.newsapp.networkservice.NewsApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApiService: NewsApiService) {
  fun callNewsApi() = newsApiService.getNewsData()
}