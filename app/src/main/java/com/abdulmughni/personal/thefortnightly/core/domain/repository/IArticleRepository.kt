package com.abdulmughni.personal.thefortnightly.core.domain.repository

import com.abdulmughni.personal.thefortnightly.core.data.Resource
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface IArticleRepository {
    fun getAllArticle(): Flow<Resource<List<Article>>>

    fun getBookmarkedArticle(): Flow<List<Article>>

    fun updateBookmarkArticle(article: Article, state: Boolean)
}