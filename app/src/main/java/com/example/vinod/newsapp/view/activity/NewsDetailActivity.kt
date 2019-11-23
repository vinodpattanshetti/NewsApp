package com.example.vinod.newsapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vinod.newsapp.R
import com.example.vinod.newsapp.base.utils.returnRequiredDate
import com.example.vinod.newsapp.base.utils.setImageLoader
import com.example.vinod.newsapp.databinding.ActivityNewsDetailBinding
import com.example.vinod.newsapp.model.Article
import com.example.vinod.newsapp.view.activity.NewsActivity.Companion.ARTICLE_DATA

class NewsDetailActivity : AppCompatActivity() {

  private var mBinder: ActivityNewsDetailBinding? = null
  private var article: Article? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinder = DataBindingUtil.setContentView(this, R.layout.activity_news_detail)
    article = intent.getParcelableExtra(ARTICLE_DATA)
    mBinder?.toolbar?.setNavigationOnClickListener {
      finish()
    }
    initViews()
  }

  private fun initViews() {
    mBinder?.run {
      tvHeadlineNews.text = article?.title
      tvHeadlineChannel.text = article?.source?.name
      tvNewsDate.text = returnRequiredDate(article?.publishedAt)
      tvNewsDescription.text = article?.description
      mBinder?.ivNewsImage?.let {
        setImageLoader(it, article?.urlToImage.orEmpty())
      }
    }
  }
}
