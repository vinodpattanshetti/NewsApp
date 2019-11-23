package com.example.vinod.newsapp.base.component

import android.app.Application
import com.example.vinod.newsapp.base.NewsApplication
import com.example.vinod.newsapp.base.module.ActivityBuilder
import com.example.vinod.newsapp.base.module.BaseViewModelModule
import com.example.vinod.newsapp.base.module.NetworkModule
import com.example.vinod.newsapp.base.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilder::class, BaseViewModelModule::class])
interface ApplicationComponent {
  @Component.Builder interface Builder {
    @BindsInstance fun application(mApplication: Application): Builder
    fun build(): ApplicationComponent
  }

  fun inject(newsApplication: NewsApplication)
}