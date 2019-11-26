package com.example.vinod.newsapp.utils

import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import com.example.vinod.newsapp.databinding.ItemNewsLayoutBinding
import com.example.vinod.newsapp.view.adapter.NewsListingAdapter
import org.hamcrest.Description
import org.hamcrest.Matcher

fun atPosition(position: Int, @NonNull itemMatcher: Matcher<View>): Matcher<View> {
  return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
    override fun describeTo(description: Description) {
      description.appendText("has item at position $position: ")
      itemMatcher.describeTo(description)
    }

    override fun matchesSafely(view: RecyclerView): Boolean {
      val viewHolder = view.findViewHolderForAdapterPosition(position) ?: return false
      return itemMatcher.matches(((viewHolder as NewsListingAdapter.NewsViewHolder).binder as ItemNewsLayoutBinding).tvHeadlineNews)
    }
  }
}