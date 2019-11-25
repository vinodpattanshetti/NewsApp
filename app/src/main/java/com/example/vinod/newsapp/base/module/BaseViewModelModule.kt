package com.example.vinod.newsapp.base.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vinod.newsapp.base.ViewModelKey
import com.example.vinod.newsapp.base.ViewModelProviderFactory
import com.example.vinod.newsapp.base.scope.ApplicationScope
import com.example.vinod.newsapp.base.utils.schedulers.BaseSchedulerProvider
import com.example.vinod.newsapp.base.utils.schedulers.SchedulerProvider
import com.example.vinod.newsapp.viewmodel.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/*
*  This Module class 'BaseViewModelModule' provides object of
*  ViewModelProviderFactory, NewsViewModel and SchedulerProvider objects to
*  ApplicationComponent.kt for dependency injection
* */
@Module abstract class BaseViewModelModule {
  @Binds @ApplicationScope
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

  @Binds @IntoMap @ViewModelKey(NewsViewModel::class) abstract fun bindRegistrationViewModule(
    newsViewModel: NewsViewModel
  ): ViewModel

  @Binds @ApplicationScope
  abstract fun provideSchedulerProvider(schedulerProvider: SchedulerProvider): BaseSchedulerProvider
}