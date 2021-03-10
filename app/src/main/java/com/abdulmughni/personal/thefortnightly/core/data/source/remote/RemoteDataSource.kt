package com.abdulmughni.personal.thefortnightly.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiService
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.ResultsItem
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.TopStoriesResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService){
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }
    fun getAllArticle(): Flowable<ApiResponse<List<ResultsItem>>> {
        val resultData = PublishSubject.create<ApiResponse<List<ResultsItem>>>()

        //get data from remote api
        val client = apiService.getTopStoriesHome(ApiService.API_KEY)
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({response ->
                val dataArray = response.results
                resultData.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })
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

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }
}