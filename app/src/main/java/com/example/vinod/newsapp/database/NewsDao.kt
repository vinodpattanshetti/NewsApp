package com.example.vinod.newsapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.vinod.newsapp.model.News

/*
* This interface 'NewsDao' is used to insert(insertNews() method) News data to the Room database
* and fetch from database whenever it's required using fetchAllNewsArticles() method
* */
@Dao interface NewsDao {

  @Insert fun insertNews(news: News?)

  @Query("SELECT * FROM News") fun fetchAllNewsArticles(): LiveData<News>

  @Query("DELETE from News") fun deleteAllNewsArticles()

}