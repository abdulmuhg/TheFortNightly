package com.abdulmughni.personal.thefortnightly.core.data.source.local

import com.abdulmughni.personal.thefortnightly.core.data.source.local.entity.ArticleEntity
import com.abdulmughni.personal.thefortnightly.core.data.source.local.room.ArticleDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val articleDao: ArticleDao) {

//    companion object {
//        private var instance: LocalDataSource? = null
//        fun getInstance(articleDao: ArticleDao): LocalDataSource =
//            instance ?: synchronized(this) {
//                instance ?: LocalDataSource(articleDao)
//            }
//    }

    fun getAllArticle(): Flow<List<ArticleEntity>> = articleDao.getAllArticle()
    fun getAllBookmarkedArticle(): Flow<List<ArticleEntity>> = articleDao.getAllBookmarkedArticle()
    suspend fun insertArticle(articleList: List<ArticleEntity>) =
        articleDao.insertArticle(articleList)

    fun updateBookmarkArticle(article: ArticleEntity, newState: Boolean) {
        article.isBookmarked = newState
        articleDao.updateBookmarkArticle(article)
    }
}