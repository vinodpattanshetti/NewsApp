package com.example.vinod.newsapp.networkservice

import com.example.vinod.newsapp.model.News
import io.reactivex.Observable
import retrofit2.http.GET

/*
* The interface 'NewsApiService' responsible for implementing Retrofit GET method.
* For news api
* https://newsapi.org/v2/everything?q=bitcoin&from=2019-11-24&sortBy=publishedAt&apiKey=c96d27cfad814260a641accf02576001
* */
interface NewsApiService {
  @GET("everything?q=bitcoin&from=2019-11-24&sortBy=publishedAt&apiKey=c96d27cfad814260a641accf02576001")
  fun getNewsData(): Observable<News>
}