package com.example.vinod.newsapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Source") @Parcelize data class Source(
  @PrimaryKey(autoGenerate = true) @NonNull @SerializedName("id1") var id1: Int = 0,
  @SerializedName("id") @Expose var id: String? = null, @SerializedName("name") @Expose
  var name: String? = null
) : Parcelable
