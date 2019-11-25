package com.example.vinod.newsapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.vinod.newsapp.model.News


/*
* Abstract Room database is used to add "News Data class" and "fetch News data" from database
* This class is called after actual api hit
* https://newsapi.org/v2/everything?q=bitcoin&from=2019-11-24&sortBy=publishedAt&apiKey=c96d27cfad814260a641accf02576001
* Once we get data from above api we are storing it to the Room database.
* */

@Database(entities = [News::class], version = 2, exportSchema = false)
@TypeConverters(DataConverter::class) abstract class NewsDatabase : RoomDatabase() {
  abstract fun getINewsDao(): NewsDao
}
