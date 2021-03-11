package com.abdulmughni.personal.thefortnightly.core.data.source.local.room

import androidx.room.*
import com.abdulmughni.personal.thefortnightly.core.data.source.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getAllArticle(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM article WHERE isBookmarked = 1")
    fun getAllBookmarkedArticle(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articleList: List<ArticleEntity>)

    @Update
    fun updateBookmarkArticle(article: ArticleEntity)

}