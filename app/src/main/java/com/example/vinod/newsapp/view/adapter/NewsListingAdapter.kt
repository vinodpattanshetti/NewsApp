package com.example.vinod.newsapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.vinod.newsapp.R
import com.example.vinod.newsapp.base.utils.orDefaultInt
import com.example.vinod.newsapp.databinding.ItemNewsLayoutBinding
import com.example.vinod.newsapp.model.Article
import com.example.vinod.newsapp.model.News

class NewsListingAdapter(
  private val news: News?, private val iActivityCommunicator: IActivityCommunicator
) : RecyclerView.Adapter<NewsListingAdapter.NewsViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_layout, parent, false)
    return NewsViewHolder(view)
  }

  override fun getItemCount(): Int {
    return news?.articles?.size.orDefaultInt()
  }

  override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
    val article = news?.articles?.get(position)
    holder.binder?.run {
      tvHeadlineNews.text = article?.title
      tvHeadlineChannel.text = article?.source?.name
      tvNewsDate.text = article?.publishedAt
      Glide.with(ivNewsImage.context).load(article?.urlToImage)
        .apply(RequestOptions.placeholderOf(R.color.colorPrimary)).into(ivNewsImage)
      ivNewsImage.setOnClickListener { iActivityCommunicator.onItemSelected(article, position) }
    }
  }

  inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binder: ItemNewsLayoutBinding? = DataBindingUtil.bind(view)
  }

  interface IActivityCommunicator {
    fun onItemSelected(article: Article?, position: Int)
  }

}