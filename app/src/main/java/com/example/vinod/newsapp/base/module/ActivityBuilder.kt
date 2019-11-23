package com.example.vinod.newsapp.base.module

import com.example.vinod.newsapp.view.activity.NewsActivity
import com.example.vinod.newsapp.base.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
  @ActivityScope
  @ContributesAndroidInjector
  abstract fun bindNewsActivity(): NewsActivity
}