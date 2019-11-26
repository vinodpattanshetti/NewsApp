package com.example.vinod.newsapp.utils

import com.example.vinod.newsapp.model.Article
import com.example.vinod.newsapp.model.News
import com.example.vinod.newsapp.model.Source

fun getNewsSampleDataModel() = News(
  id = 1,
  status = "ok",
  totalResults = 131,
  articles = getArticlesModel(),
  code = "",
  message = "",
  isError = false
)


fun getArticlesModel(): ArrayList<Article> {
  val mList = ArrayList<Article>()
  val article1 = Article().apply {
    val testSource = Source().apply {
      id = "100"
      name = "Seekingalpha.com"
    }
    source = testSource
    author = "SA Editor Pranav Ghumatkar"
    title = "On the hour"
    description =
      "Dow +0.09%.10-yr +0.15%.Euro -0.02% vs. dollar.Crude +0.90% to \$58.53Gold -0.15% to \$1,461.55.Bitcoin -1.60% to \$7,104.2"
    url = "https://seekingalpha.com/news/3522113-hour"
    urlToImage =
      "https://static3.seekingalpha.com/assets/og_image_192-59bfd51c9fe6af025b2f9f96c807e46f8e2f06c5ae787b15bf1423e6c676d4db.png"
    publishedAt = "2019-11-26T15:00:51Z"
    content =
      "Dow +0.09%.\\r\\n10-yr +0.15%.\\r\\nEuro -0.02% vs. dollar.\\r\\nCrude +0.90% to \$58.53\\r\\nGold -0.15% to \$1,461.55.\\r\\nBitcoin -1.60% to \$7,104.2"
  }
  mList.add(article1)
  return mList
}

fun getExpectedForecastData() {

} /*= mutableListOf(
  ForecastItem("Saturday", "21.0"), ForecastItem("Sunday", "22.0"),
  ForecastItem("Monday", "23.0"), ForecastItem("Tuesday", "24.0"))*/