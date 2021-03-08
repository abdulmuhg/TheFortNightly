package com.abdulmughni.personal.thefortnightly.core.utils

import com.abdulmughni.personal.thefortnightly.core.data.source.local.entity.ArticleEntity
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.ResultsItem
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article

object DataMapper {
    fun mapResponsesToEntities(input: List<ResultsItem>): List<ArticleEntity> {
        val tourismList = ArrayList<ArticleEntity>()
        input.map {
            val tourism = ArticleEntity(
                title = it.title!!,
                abstracts = it.jsonMemberAbstract!!,
                itemType = it.itemType!!,
                byLine = it.byline!!,
                publishedDate = it.publishedDate!!,
                materialTypeFacet = it.materialTypeFacet!!,
                kicker = it.kicker!!,
                url = it.url!!,
                thumbnail = it.multimedia?.get(0)?.url!!,
                shortUrl = it.shortUrl!!,
                updateDate = it.updatedDate!!,
                createdDate = it.createdDate!!,
                isBookmarked = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<ArticleEntity>): List<Article> =
        input.map {
            Article(
                articleId = it.articleId.toString(),
                title = it.title,
                abstracts = it.abstracts,
                itemType = it.itemType,
                byLine = it.byLine,
                publishedDate = it.publishedDate,
                materialTypeFacet = it.materialTypeFacet,
                kicker = it.kicker,
                url = it.url,
                thumbnail = it.thumbnail,
                shortUrl = it.shortUrl,
                updateDate = it.updateDate,
                createdDate = it.createdDate,
                isBookmarked = it.isBookmarked
            )
        }

    fun mapDomainToEntity(input: Article) = ArticleEntity(
        articleId = input.articleId.toInt(),
        title = input.title,
        abstracts = input.abstracts,
        itemType = input.itemType,
        byLine = input.byLine,
        publishedDate = input.publishedDate,
        materialTypeFacet = input.materialTypeFacet,
        kicker = input.kicker,
        url = input.url,
        thumbnail = input.thumbnail,
        shortUrl = input.shortUrl,
        updateDate = input.updateDate,
        createdDate = input.createdDate,
        isBookmarked = input.isBookmarked
    )
}