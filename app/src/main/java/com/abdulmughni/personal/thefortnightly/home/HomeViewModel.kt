package com.abdulmughni.personal.thefortnightly.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(articleUseCase: ArticleUseCase) : ViewModel() {
    val article = articleUseCase.getAllArticle().asLiveData()
}