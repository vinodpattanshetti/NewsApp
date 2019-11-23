package com.example.vinod.newsapp.base.utils

import retrofit2.HttpException
import java.io.IOException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import com.example.vinod.newsapp.model.Result

const val GENERAL_ERROR = "General Error"
const val NETWORK_ERROR = "Network Error"
const val SERVER_ERROR = "Server Error"

fun Throwable.getError(): Result.Error {
  return when (this) {
    is SocketTimeoutException -> Result.Error(Throwable(GENERAL_ERROR))
    is NoRouteToHostException -> Result.Error(Throwable(GENERAL_ERROR))
    is IOException -> Result.Error(Throwable(NETWORK_ERROR))
    is HttpException -> {
      if (this.code() == 500) Result.Error(Throwable(SERVER_ERROR))
      else Result.Error(Throwable(GENERAL_ERROR))
    }
    else -> Result.Error(Throwable(GENERAL_ERROR))
  }
}