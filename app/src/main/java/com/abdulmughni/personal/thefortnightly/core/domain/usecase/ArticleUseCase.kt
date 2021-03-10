package com.abdulmughni.personal.thefortnightly.core.domain.usecase

import androidx.lifecycle.LiveData
import com.abdulmughni.personal.thefortnightly.core.data.Resource
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import io.reactivex.Flowable

interface ArticleUseCase {
    fun getAllArticle(): Flowable<Resource<List<Article>>>

    fun getBookmarkedArticle(): Flowable<List<Article>>

    fun updateBookmarkArticle(article: Article, state: Boolean)
}