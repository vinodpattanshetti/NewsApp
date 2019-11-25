package com.example.vinod.newsapp.database

import androidx.room.TypeConverter
import com.example.vinod.newsapp.model.Article
import com.example.vinod.newsapp.model.News
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/*
* Sometimes, the app needs to use a custom data type whose value
* you would like to store in a single database column. To add this
* kind of support for custom types, we should provide a TypeConverter,
* which converts a custom class to and from a known type that Room can persist.
* */

class DataConverter {
  @TypeConverter fun fromNews(value: News?): String? {
    val gson = Gson()
    val type = object : TypeToken<News?>() {}.type
    return gson.toJson(value, type)
  }

  @TypeConverter fun toNews(value: String?): News? {
    val gson = Gson()
    val type = object : TypeToken<News?>() {}.type
    return gson.fromJson(value, type)
  }

  @TypeConverter fun fromArticle(value: ArrayList<Article>?): String? {
    val gson = Gson()
    val type = object : TypeToken<ArrayList<Article>?>() {}.type
    return gson.toJson(value, type)
  }

  @TypeConverter fun toArticle(value: String?): ArrayList<Article>? {
    val gson = Gson()
    val type = object : TypeToken<ArrayList<Article>?>() {}.type
    return gson.fromJson(value, type)
  }
}