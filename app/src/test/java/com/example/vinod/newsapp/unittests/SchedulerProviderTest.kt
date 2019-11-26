package com.example.vinod.newsapp.unittests

import com.example.vinod.newsapp.base.utils.schedulers.BaseSchedulerProvider
import io.reactivex.schedulers.Schedulers

class SchedulerProviderTest : BaseSchedulerProvider {

  override fun computation() = Schedulers.trampoline()
  override fun ui() = Schedulers.trampoline()
  override fun io() = Schedulers.trampoline()

}