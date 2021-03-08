package com.abdulmughni.personal.thefortnightly.core.data.source.remote

class RemoteDataSource {
    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000
        private const val TAG = "RemoteDataSource"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }
    fun getAllArticle(){}
}