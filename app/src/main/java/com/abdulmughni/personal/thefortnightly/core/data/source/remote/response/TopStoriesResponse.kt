package com.abdulmughni.personal.thefortnightly.core.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class TopStoriesResponse(
	val copyright: String? = null,
	val lastUpdated: String? = null,
	val section: String? = null,
	val results: List<ResultsItem?>? = null,
	val numResults: Int? = null,
	val status: String? = null
)

data class ResultsItem(
	val perFacet: List<String?>? = null,
	val subsection: String? = null,
	val itemType: String? = null,
	val orgFacet: List<Any?>? = null,
	val section: String? = null,
	val jsonMemberAbstract: String? = null,
	val title: String? = null,
	val desFacet: List<String?>? = null,
	val uri: String? = null,
	val url: String? = null,
	val shortUrl: String? = null,
	val materialTypeFacet: String? = null,
	val multimedia: List<MultimediaItem?>? = null,
	val geoFacet: List<String?>? = null,
	val updatedDate: String? = null,
	val createdDate: String? = null,
	val byline: String? = null,
	val publishedDate: String? = null,
	val kicker: String? = null
)

data class MultimediaItem(
	val copyright: String? = null,
	val subtype: String? = null,
	val format: String? = null,
	val width: Int? = null,
	val caption: String? = null,
	val type: String? = null,
	val url: String? = null,
	val height: Int? = null
)
