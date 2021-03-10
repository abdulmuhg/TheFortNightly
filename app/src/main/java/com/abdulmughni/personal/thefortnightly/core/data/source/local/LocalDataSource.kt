package com.abdulmughni.personal.thefortnightly.core.data.source.local

import androidx.lifecycle.LiveData
import com.abdulmughni.personal.thefortnightly.core.data.source.local.entity.ArticleEntity
import com.abdulmughni.personal.thefortnightly.core.data.source.local.room.ArticleDao
import io.reactivex.Flowable

class LocalDataSource private constructor(private val articleDao: ArticleDao){
    companion object {
        private var instance: LocalDataSource? = null
        fun getInstance(articleDao: ArticleDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(articleDao)
            }
    }
    fun getAllArticle(): Flowable<List<ArticleEntity>> = articleDao.getAllArticle()
    fun getAllBookmarkedArticle(): Flowable<List<ArticleEntity>> = articleDao.getAllBookmarkedArticle()
    fun insertArticle(articleList: List<ArticleEntity>) = articleDao.insertArticle(articleList)
    fun updateBookmarkArticle(article: ArticleEntity, newState: Boolean) {
        article.isBookmarked = newState
        articleDao.updateBookmarkArticle(article)
    }
}