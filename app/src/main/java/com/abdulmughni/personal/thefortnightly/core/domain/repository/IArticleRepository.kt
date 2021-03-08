package com.abdulmughni.personal.thefortnightly.core.domain.repository

import androidx.lifecycle.LiveData
import com.abdulmughni.personal.thefortnightly.core.data.Resource
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article

interface IArticleRepository {
    fun getAllArticle(): LiveData<Resource<List<Article>>>

    fun getBookmarkedArticle(): LiveData<List<Article>>

    fun updateBookmarkArticle(article: Article, state: Boolean)
}