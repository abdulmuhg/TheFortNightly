package com.abdulmughni.personal.thefortnightly.home

import androidx.lifecycle.ViewModel
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase

class HomeViewModel(articleUseCase: ArticleUseCase) : ViewModel() {
    val article = articleUseCase.getAllArticle()
}