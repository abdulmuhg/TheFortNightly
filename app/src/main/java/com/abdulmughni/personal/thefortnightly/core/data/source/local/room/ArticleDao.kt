package com.abdulmughni.personal.thefortnightly.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.abdulmughni.personal.thefortnightly.core.data.source.local.entity.ArticleEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getAllArticle(): Flowable<List<ArticleEntity>>

    @Query("SELECT * FROM article WHERE isBookmarked = 1")
    fun getAllBookmarkedArticle(): Flowable<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(articleList: List<ArticleEntity>): Completable

    @Update
    fun updateBookmarkArticle(article: ArticleEntity)

}