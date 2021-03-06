package com.abdulmughni.personal.thefortnightly.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.abdulmughni.personal.thefortnightly.core.data.ArticleRepository
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase

class DetailViewModel @ViewModelInject constructor(private val articleUseCase: ArticleUseCase) : ViewModel() {
    fun setFavoriteTourism(article: Article, newStatus:Boolean) = articleUseCase.updateBookmarkArticle(article, newStatus)
}