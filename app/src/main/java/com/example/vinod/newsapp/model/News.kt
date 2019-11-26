package com.example.vinod.newsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

@Entity(tableName = "News") data class News(
  @PrimaryKey(autoGenerate = true) @NonNull @SerializedName("id") var id: Int = 0,
  @SerializedName("status") @Expose var status: String? = null, @SerializedName("totalResults")
  @Expose var totalResults: Int? = null, @SerializedName("articles") @Expose
  var articles: ArrayList<Article>? = null, @SerializedName("code") @Expose
  var code: String? = null, @SerializedName("message") @Expose var message: String? = null,
  var isError: Boolean? = false

)
