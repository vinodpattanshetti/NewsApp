package com.example.vinod.newsapp.model

open class BaseApiResponse {

  var error: ErrorResponse? = null

  fun <T : Any> getResult(data: T): Result<T> {
    return error?.let {
      Result.Error(Throwable(error?.message))
    } ?: run {
      Result.Success(data)
    }
  }

}