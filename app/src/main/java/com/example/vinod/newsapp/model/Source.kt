package com.example.vinod.newsapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Source(
  @SerializedName("id") @Expose var id: String? = null, @SerializedName("name") @Expose
  var name: String? = null
): Parcelable
