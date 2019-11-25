package com.example.vinod.newsapp.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.vinod.newsapp.R
import com.example.vinod.newsapp.base.utils.SpacesItemDecoration
import com.example.vinod.newsapp.base.utils.convertDpToPx
import com.example.vinod.newsapp.base.utils.hideView
import com.example.vinod.newsapp.base.utils.showView
import com.example.vinod.newsapp.database.NewsDatabase
import com.example.vinod.newsapp.databinding.ActivityNewsBinding
import com.example.vinod.newsapp.model.Article
import com.example.vinod.newsapp.model.News
import com.example.vinod.newsapp.view.adapter.NewsListingAdapter
import com.example.vinod.newsapp.viewmodel.NewsViewModel
import dagger.android.AndroidInjection
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * This class 'NewsActivity' is responsible for displaying News Data Articles on xml layout 'activity_news' from Api
 * https://newsapi.org/v2/everything?q=bitcoin&from=2019-11-24&sortBy=publishedAt&apiKey=c96d27cfad814260a641accf02576001
 * or News Room database
 */
class NewsActivity : AppCompatActivity(), NewsListingAdapter.IActivityCommunicator {

  private var mBinder: ActivityNewsBinding? = null
  @Inject lateinit var mViewModel: ViewModelProvider.Factory
  private lateinit var mWeatherViewModel: NewsViewModel

  private var mNews: News? = null
  private var mNewsDatabase: NewsDatabase? = null
  private var mSubscriptions: CompositeDisposable = CompositeDisposable()

  companion object {
    const val ARTICLE_DATA = "ARTICLE_DATA"
    private const val NAME = "news_task"
    private const val VALUE_SIXTEEN = 16f
    private const val VALUE_TWENTY_FOUR = 24f
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinder = DataBindingUtil.setContentView(this, R.layout.activity_news)
    injectDaggerAndNewsRoomDataBase()
    initViews()
  }

  private fun injectDaggerAndNewsRoomDataBase() {
    AndroidInjection.inject(this)
    mNewsDatabase =
      Room.databaseBuilder(this, NewsDatabase::class.java, NAME).fallbackToDestructiveMigration()
        .build()
    mWeatherViewModel = ViewModelProviders.of(this, mViewModel).get(NewsViewModel::class.java)
  }

  /**
   * The method 'initViews' responsible for calling News Room database
   * if News Data is available, if News Data is not
   * available then it does calls the News Data api.
   */
  private fun initViews() {
    mBinder?.pbProgress?.showView()
    getNewsArticleData()?.observe(this, Observer {
      mNews = null
      mNews = it
      if (null == mNews) {
        mWeatherViewModel.initNewsApiCall()
        mWeatherViewModel.mNewsDateResponse.observe(this, Observer { news ->
          mNews = news
          insertNewsArticlesToDatabase(mNews)
        })
      }
      initNewsListAdapter()
    })
  }

  // Initializing News list adapter which displays the Article lists
  private fun initNewsListAdapter() {
    mBinder?.pbProgress?.hideView()
    mBinder?.rvNewsList?.run {
      layoutManager = LinearLayoutManager(this@NewsActivity)
      addItemDecoration(
        SpacesItemDecoration(
          convertDpToPx(this@NewsActivity, VALUE_SIXTEEN).toInt(),
          convertDpToPx(this@NewsActivity, VALUE_TWENTY_FOUR).toInt()
        )
      )
      itemAnimator = DefaultItemAnimator()
      val newsAdapter = NewsListingAdapter(mNews, this@NewsActivity)
      adapter = newsAdapter
    }
  }

  // Overridden method to call onItemSelected of News list page to call News Detail activity page
  override fun onItemSelected(article: Article?, position: Int) {
    val intent = Intent(this, NewsDetailActivity::class.java)
    intent.putExtra(ARTICLE_DATA, article)
    startActivity(intent)
  }

  /**
   * The method 'insertNewsArticlesToDatabase' is responsible for inserting News Data articles
   * to Room database.
   */
  private fun insertNewsArticlesToDatabase(news: News?) {
    mSubscriptions.add(Completable.fromAction {
      mNewsDatabase?.getINewsDao()?.insertNews(news)
    }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
      Log.e("Database add operation", "Added Data to Database Successfully")
    })
  }

  /**
   * The method 'getNewsArticleData' is responsible for fetching News Data articles
   * from Room database, it returns LiveData object of News data class.
   */
  private fun getNewsArticleData(): LiveData<News>? {
    return mNewsDatabase?.getINewsDao()?.fetchAllNewsArticles()
  }
}
