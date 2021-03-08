package com.abdulmughni.personal.thefortnightly.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.abdulmughni.personal.thefortnightly.core.data.source.local.entity.ArticleEntity

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getAllArticle(): LiveData<List<ArticleEntity>>

    @Query("SELECT * FROM article WHERE isBookmarked = 1")
    fun getAllBookmarkedArticle(): LiveData<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(articleList: List<ArticleEntity>)

    @Update
    fun updateBookmarkArticle(article: ArticleEntity)

}