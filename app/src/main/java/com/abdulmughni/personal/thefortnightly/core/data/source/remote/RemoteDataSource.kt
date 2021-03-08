package com.abdulmughni.personal.thefortnightly.core.data.source.remote
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiService
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.ResultsItem
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.TopStoriesResponse
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
    fun getAllArticle(): LiveData<ApiResponse<List<ResultsItem>>> {
        val resultData = MutableLiveData<ApiResponse<List<ResultsItem>>>()

        //get data from remote api
        val client = apiService.getTopStoriesHome(ApiService.API_KEY)

        client.enqueue(object : Callback<TopStoriesResponse> {
            override fun onResponse(
                call: Call<TopStoriesResponse>,
                response: Response<TopStoriesResponse>
            ) {
                val dataArray = response.body()?.results
                if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }
            override fun onFailure(call: Call<TopStoriesResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}