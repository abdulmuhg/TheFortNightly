package com.abdulmughni.personal.thefortnightly.bookmark

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase
import javax.inject.Inject

class BookmarkViewModel @ViewModelInject constructor(articleUseCase: ArticleUseCase) : ViewModel() {
    val bookmarkArticle = articleUseCase.getBookmarkedArticle().asLiveData()
}