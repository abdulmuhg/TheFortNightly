package com.abdulmughni.personal.thefortnightly.core.domain.usecase

import androidx.lifecycle.LiveData
import com.abdulmughni.personal.thefortnightly.core.data.ArticleRepository
import com.abdulmughni.personal.thefortnightly.core.data.Resource
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.core.domain.repository.IArticleRepository
import io.reactivex.Flowable

class ArticleInteractor (private val articleRepository: IArticleRepository): ArticleUseCase {
    override fun getAllArticle(): Flowable<Resource<List<Article>>> = articleRepository.getAllArticle()

    override fun getBookmarkedArticle(): Flowable<List<Article>> = articleRepository.getBookmarkedArticle()

    override fun updateBookmarkArticle(article: Article, state: Boolean) =
        articleRepository.updateBookmarkArticle(article, state)
}