package com.abdulmughni.personal.thefortnightly.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdulmughni.personal.thefortnightly.bookmark.BookmarkViewModel
import com.abdulmughni.personal.thefortnightly.core.di.Injection
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase
import com.abdulmughni.personal.thefortnightly.detail.DetailViewModel
import com.abdulmughni.personal.thefortnightly.home.HomeViewModel

class ViewModelFactory private constructor(private val articleUseCase: ArticleUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideArticleUseCase(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(articleUseCase) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                BookmarkViewModel(articleUseCase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(articleUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}