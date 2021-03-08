package com.abdulmughni.personal.thefortnightly.core.domain.usecase

import androidx.lifecycle.LiveData
import com.abdulmughni.personal.thefortnightly.core.data.Resource
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article

interface ArticleUseCase {
    fun getAllArticle(): LiveData<Resource<List<Article>>>

    fun getBookmarkedArticle(): LiveData<List<Article>>

    fun updateBookmarkArticle(article: Article, state: Boolean)
}