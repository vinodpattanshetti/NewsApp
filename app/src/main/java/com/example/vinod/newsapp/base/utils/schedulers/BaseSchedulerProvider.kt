package com.example.vinod.newsapp.base.utils.schedulers

import io.reactivex.Scheduler

interface BaseSchedulerProvider {
  fun computation(): Scheduler
  fun io(): Scheduler
  fun ui(): Scheduler
}