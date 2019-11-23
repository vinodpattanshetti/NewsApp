package com.example.vinod.newsapp.networkservice

import com.example.vinod.newsapp.model.News
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsApiService {

  @GET("everything?q=bitcoin&from=2019-10-23&sortBy=publishedAt&apiKey=3150cd7e7ff54633b59d4b383c354b51")
  fun getNewsData(): Observable<News>
  /*@GET("current.json?key=99b51b0859294877a8732802191302&q=bangalore")
  fun getCurrent(): Observable<CurrentResponse>

  @GET("forecast.json?key=99b51b0859294877a8732802191302&q=bangalore&days=5")
  fun getForecast(): Observable<ForecastResponse>*/

}