package com.example.vinod.newsapp.base.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vinod.newsapp.base.ViewModelProviderFactory
import com.example.vinod.newsapp.base.scope.ApplicationScope
import com.example.vinod.newsapp.base.utils.schedulers.BaseSchedulerProvider
import com.example.vinod.newsapp.base.utils.schedulers.SchedulerProvider
import com.example.vinod.newsapp.viewmodel.NewsViewModel
import com.example.vinod.weatherapplication.base.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BaseViewModelModule {
  @Binds
  @ApplicationScope
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(NewsViewModel::class)
  abstract fun bindRegistrationViewModule(newsViewModel: NewsViewModel): ViewModel

  @Binds
  @ApplicationScope
  abstract fun provideSchedulerProvider(schedulerProvider: SchedulerProvider): BaseSchedulerProvider
}