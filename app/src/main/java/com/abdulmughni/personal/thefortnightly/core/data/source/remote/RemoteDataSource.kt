package com.abdulmughni.personal.thefortnightly.core.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiService
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.ResultsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

//    companion object {
//        @Volatile
//        private var instance: RemoteDataSource? = null
//
//        fun getInstance(service: ApiService): RemoteDataSource =
//            instance ?: synchronized(this) {
//                instance ?: RemoteDataSource(service)
//            }
//    }

    suspend fun getAllArticle(): Flow<ApiResponse<List<ResultsItem>>> {

        return flow {
            try {
                val response = apiService.getTopStoriesHome(ApiService.API_KEY)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

        //get data from remote api

//        val client = apiService.getTopStoriesHome(ApiService.API_KEY)
//        client
//            .subscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .take(1)
//            .subscribe({ response ->
//                val dataArray = response.results
//                resultData.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
//            },
//                { error ->
//                    resultData.onNext(ApiResponse.Error(error.message.toString()))
//                    Log.e("RemoteDataSource", error.toString())
//                })


//        client.enqueue(object : Callback<TopStoriesResponse> {
//            override fun onResponse(
//                call: Call<TopStoriesResponse>,
//                response: Response<TopStoriesResponse>
//            ) {
//                val dataArray = response.body()?.results
//                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
//            }
//            override fun onFailure(call: Call<TopStoriesResponse>, t: Throwable) {
//                resultData.value = ApiResponse.Error(t.message.toString())
//                Log.e("RemoteDataSource", t.message.toString())
//            }
//        })

    }
}