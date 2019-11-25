package com.example.vinod.newsapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Article") @Parcelize data class Article(
  @PrimaryKey(autoGenerate = true) @NonNull @SerializedName("id") var id: Int = 0,
  @SerializedName("source") @Expose var source: Source? = null, @SerializedName("author") @Expose
  var author: String? = null, @SerializedName("title") @Expose var title: String? = null,
  @SerializedName("description") @Expose var description: String? = null, @SerializedName("url")
  @Expose var url: String? = null, @SerializedName("urlToImage") @Expose
  var urlToImage: String? = null, @SerializedName("publishedAt") @Expose
  var publishedAt: String? = null, @SerializedName("content") @Expose var content: String? = null
) : Parcelable
