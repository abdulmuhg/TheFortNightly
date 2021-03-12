package com.abdulmughni.personal.thefortnightly.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    var articleId: String,
    var title: String,
    var abstracts: String,
    var itemType: String,
    var byLine: String,
    var updateDate: String,
    var createdDate: String,
    var publishedDate: String,
    var materialTypeFacet: String,
    var kicker: String,
    var url: String,
    var thumbnail: String?,
    var shortUrl: String,
    var isBookmarked: Boolean = false
) : Parcelable