package com.abdulmughni.personal.thefortnightly.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "articleId")
    var articleId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "abstract")
    var abstract: String,

    @ColumnInfo(name = "item_type")
    var itemType: String,

    @ColumnInfo(name = "update_date")
    var updateDate: String,

    @ColumnInfo(name = "created_date")
    var createdDate: String,

    @ColumnInfo(name = "published_date")
    var publishedDate: String,

    @ColumnInfo(name = "material_type_facet")
    var materialTypeFacet: String,

    @ColumnInfo(name = "kicker")
    var kicker: String
) : Parcelable