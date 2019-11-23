package com.example.vinod.newsapp.base

import android.app.Activity
import android.app.Application
import com.example.vinod.newsapp.base.component.ApplicationComponent
import com.example.vinod.newsapp.base.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class NewsApplication : Application(), HasActivityInjector {

  @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

  private lateinit var mApplicationComponent: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    mApplicationComponent = DaggerApplicationComponent.builder().application(this).build()
    mApplicationComponent.inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity> {
    return activityDispatchingAndroidInjector
  }
}