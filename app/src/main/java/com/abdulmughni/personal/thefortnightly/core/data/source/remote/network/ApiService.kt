package com.abdulmughni.personal.thefortnightly.core.data.source.remote.network

import com.abdulmughni.personal.thefortnightly.BuildConfig
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.TopStoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val API_KEY: String = BuildConfig.API_KEY
    }
    @GET("home.json")
    fun getTopStoriesHome(
        @Query("api-key") apiKey: String
    ): Call<TopStoriesResponse>
}