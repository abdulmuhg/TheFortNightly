package com.abdulmughni.personal.thefortnightly.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopStoriesResponse(

		@field:SerializedName("copyright")
		val copyright: String? = null,

		@field:SerializedName("last_updated")
		val lastUpdated: String? = null,

		@field:SerializedName("section")
		val section: String? = null,

		@field:SerializedName("results")
		val results: List<ResultsItem>,

		@field:SerializedName("num_results")
		val numResults: Int? = null,

		@field:SerializedName("status")
		val status: String? = null
) : Parcelable

@Parcelize
data class ResultsItem(

		@field:SerializedName("per_facet")
		val perFacet: List<String?>? = null,

		@field:SerializedName("subsection")
		val subsection: String? = null,

		@field:SerializedName("item_type")
		val itemType: String? = null,

		@field:SerializedName("org_facet")
		val orgFacet: List<String?>? = null,

		@field:SerializedName("section")
		val section: String? = null,

		@field:SerializedName("abstract")
		val jsonMemberAbstract: String? = null,

		@field:SerializedName("title")
		val title: String? = null,

		@field:SerializedName("des_facet")
		val desFacet: List<String?>? = null,

		@field:SerializedName("uri")
		val uri: String? = null,

		@field:SerializedName("url")
		val url: String? = null,

		@field:SerializedName("short_url")
		val shortUrl: String? = null,

		@field:SerializedName("material_type_facet")
		val materialTypeFacet: String? = null,

		@field:SerializedName("multimedia")
		val multimedia: List<MultimediaItem?>? = null,

		@field:SerializedName("geo_facet")
		val geoFacet: List<String?>? = null,

		@field:SerializedName("updated_date")
		val updatedDate: String? = null,

		@field:SerializedName("created_date")
		val createdDate: String? = null,

		@field:SerializedName("byline")
		val byline: String? = null,

		@field:SerializedName("published_date")
		val publishedDate: String? = null,

		@field:SerializedName("kicker")
		val kicker: String? = null
) : Parcelable

@Parcelize
data class MultimediaItem(

		@field:SerializedName("copyright")
		val copyright: String? = null,

		@field:SerializedName("subtype")
		val subtype: String? = null,

		@field:SerializedName("format")
		val format: String? = null,

		@field:SerializedName("width")
		val width: Int? = null,

		@field:SerializedName("caption")
		val caption: String? = null,

		@field:SerializedName("type")
		val type: String? = null,

		@field:SerializedName("url")
		val url: String? = null,

		@field:SerializedName("height")
		val height: Int? = null
) : Parcelable
