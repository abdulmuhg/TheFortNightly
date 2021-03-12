package com.abdulmughni.personal.thefortnightly.core.domain.usecase

import com.abdulmughni.personal.thefortnightly.core.data.Resource
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.core.domain.repository.IArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleInteractor @Inject constructor(private val articleRepository: IArticleRepository) :
    ArticleUseCase {
    override fun getAllArticle(): Flow<Resource<List<Article>>> = articleRepository.getAllArticle()

    override fun getBookmarkedArticle(): Flow<List<Article>> =
        articleRepository.getBookmarkedArticle()

    override fun updateBookmarkArticle(article: Article, state: Boolean) =
        articleRepository.updateBookmarkArticle(article, state)
}