package com.abdulmughni.personal.thefortnightly.bookmark

import androidx.lifecycle.ViewModel
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase

class BookmarkViewModel(articleUseCase: ArticleUseCase) : ViewModel() {
    val bookmarkArticle = articleUseCase.getBookmarkedArticle()
}