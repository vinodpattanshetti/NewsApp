package com.example.vinod.newsapp.unittests

import androidx.arch.core.executor.testing.*
import com.example.vinod.newsapp.repository.NewsRepository
import com.example.vinod.newsapp.testmodels.getArticleSize
import com.example.vinod.newsapp.testmodels.getNewsSampleDataModel
import com.example.vinod.newsapp.testmodels.getNewsSampleDataModelForFailure
import com.example.vinod.newsapp.viewmodel.NewsViewModel
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class) class NewsViewModelTest {

  @get:Rule val rule: TestRule = InstantTaskExecutorRule() as TestRule

  @Mock private lateinit var repository: NewsRepository

  private lateinit var viewModel: NewsViewModel

  @Before fun setUp() {
    MockitoAnnotations.initMocks(this)
    viewModel = NewsViewModel(repository,
      SchedulerProviderTest()
    )
  }

  /**
   * Function 'testToCheckIsNewsApiSuccessful' to check is NewsApi is successful using dummy data provided
   * by method getNewsSampleDataModel()
   */
  @Test fun testToCheckIsNewsApiSuccessful() {
    Mockito.`when`(repository.callNewsApi()).thenReturn(Observable.just(getNewsSampleDataModel()))
    viewModel.initNewsApiCall()
    Assert.assertEquals(getNewsSampleDataModel(), viewModel.mNewsDateResponse.value)
  }

  /**
   * Function 'testToCheckIsNewsApiFailure' to check is NewsApi is failure using dummy data provided
   * by method getNewsSampleDataModelForFailure()
   */
  @Test fun testToCheckIsNewsApiFailure() {
    Mockito.`when`(repository.callNewsApi())
      .thenReturn(Observable.just(getNewsSampleDataModelForFailure()))
    viewModel.initNewsApiCall()
    Assert.assertEquals(getNewsSampleDataModelForFailure(), viewModel.mNewsDateResponse.value)
  }

  /**
   * Function 'testToCheckArticleListIsEmptyOrNot' to check is NewsApi data has 20 articles or not using dummy data provided
   * by method getArticleSize()
   */
  @Test fun testToCheckArticleListIsEmptyOrNot() {
    Mockito.`when`(repository.callNewsApi()).thenReturn(Observable.just(getArticleSize()))
    viewModel.initNewsApiCall()
    Assert.assertEquals(
      getArticleSize().articles?.size,
      viewModel.mNewsDateResponse.value?.articles?.size
    )
  }

  /**
   * Function 'testToCheckFirstArticleTitle' to check is News Article title using dummy data provided
   * by method getNewsSampleDataModel()
   */
  @Test fun testToCheckFirstArticleTitle() {
    Mockito.`when`(repository.callNewsApi()).thenReturn(Observable.just(getNewsSampleDataModel()))
    viewModel.initNewsApiCall()
    Assert.assertEquals(
      getNewsSampleDataModel().articles?.get(0)?.title,
      viewModel.mNewsDateResponse.value?.articles?.get(0)?.title
    )
  }

  /**
   * Function 'testToCheckFirstArticleDescription' to check is News Article description using dummy data provided
   * by method getNewsSampleDataModel()
   */
  @Test fun testToCheckFirstArticleDescription() {
    Mockito.`when`(repository.callNewsApi()).thenReturn(Observable.just(getNewsSampleDataModel()))
    viewModel.initNewsApiCall()
    Assert.assertEquals(
      getNewsSampleDataModel().articles?.get(0)?.description,
      viewModel.mNewsDateResponse.value?.articles?.get(0)?.description
    )
  }
}