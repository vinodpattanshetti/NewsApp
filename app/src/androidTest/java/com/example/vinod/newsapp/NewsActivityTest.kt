package com.example.vinod.newsapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.example.vinod.newsapp.model.News
import com.example.vinod.newsapp.utils.DataBindingIdlingResourceRule
import com.example.vinod.newsapp.utils.TaskExecutorWithIdlingResourceRule
import com.example.vinod.newsapp.utils.atPosition
import com.example.vinod.newsapp.utils.getNewsSampleDataModel
import com.example.vinod.newsapp.view.activity.NewsActivity
import com.example.vinod.newsapp.viewmodel.NewsViewModel
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class) class NewsActivityTest {
  @Rule @JvmField val mActivityRule = ActivityTestRule(NewsActivity::class.java)

  @get:Rule @JvmField val executorRule = TaskExecutorWithIdlingResourceRule()

  @Rule @JvmField val dataBindingIdlingResourceRule = DataBindingIdlingResourceRule(mActivityRule)

  lateinit var viewModel: NewsViewModel

  lateinit var activity: NewsActivity

  @Before fun init() {
    viewModel = Mockito.mock(NewsViewModel::class.java)
    activity = mActivityRule.activity
  }

  @Test fun showError() {
    val news = News()
    news.isError = true
    activity.mNewsViewModel.mNewsDateResponse.postValue(news)
    Espresso.onView(ViewMatchers.withId(R.id.pb_progress))
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    Espresso.onView(ViewMatchers.withId(R.id.pb_progress))
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

  @Test fun checkIsProgressBarVisible() {
    val news = News()
    news.isError = true
    activity.mNewsViewModel.mNewsDateResponse.postValue(news)
    Espresso.onView(ViewMatchers.withId(R.id.pb_progress))
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

  @Test fun confirmNewsTitleNameDisplayedOrNot() {
    val news = getNewsSampleDataModel()
    activity.mNewsViewModel.mNewsDateResponse.postValue(news)
    Espresso.onView(ViewMatchers.withId(R.id.tv_headline_news))
      .check(ViewAssertions.matches(ViewMatchers.withText("On the hour")))
  }

  @Test fun populateRecyclerViewSuccess() {
    val news = getNewsSampleDataModel()
    activity.mNewsViewModel.mNewsDateResponse.postValue(news)
    Espresso.onView(ViewMatchers.withId(R.id.rv_news_list))
      .check(ViewAssertions.matches(atPosition(1, ViewMatchers.withText("On the hour"))))
  }

  @Test fun populateRecyclerViewWrongData() {
    val news = getNewsSampleDataModel()
    activity.mNewsViewModel.mNewsDateResponse.postValue(news)
    Espresso.onView(ViewMatchers.withId(R.id.rv_news_list)).check(
      ViewAssertions.matches(
        Matchers.not(
          atPosition(
            3,
            ViewMatchers.withText("7 alternativas al Bitcoin para invertir que están creciendo en 2019")
          )
        )
      )
    )
  }

}