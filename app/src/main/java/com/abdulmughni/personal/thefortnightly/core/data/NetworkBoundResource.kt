package com.abdulmughni.personal.thefortnightly.core.data

import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.thefortnightly.core.utils.AppExecutors
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {


    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(Resource.Loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(Resource.Error<ResultType>(apiResponse.errorMessage))
                }
            }
        } else {
            emitAll(loadFromDB().map { Resource.Success(it) })
        }
    }
//
//    init {
//        @Suppress("LeakingThis")
//        val dbSource = loadFromDB()
//        val db = dbSource
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .take(1)
//            .subscribe { value ->
//                dbSource.unsubscribeOn(Schedulers.io())
//                if (shouldFetch(value)) {
//                    fetchFromNetwork()
//                } else {
//                    result.onNext(Resource.Success(value))
//                }
//            }
//        mCompositeDisposable.add(db)
//    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result

//    private fun fetchFromNetwork() {
//        val apiResponse = createCall()
//        result.onNext(Resource.Loading(null))
//        val response = apiResponse
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .take(1)
//            .doOnComplete {
//                mCompositeDisposable.dispose()
//            }
//            .subscribe{ response ->
//                when(response){
//                    is ApiResponse.Success -> {
//                        saveCallResult(response.data)
//                        val dbSource = loadFromDB()
//                        dbSource.subscribeOn(Schedulers.computation())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .take(1)
//                            .subscribe {
//                                dbSource.unsubscribeOn(Schedulers.io())
//                                result.onNext(Resource.Success(it))
//                            }
//                    }
//                    is ApiResponse.Empty -> {
//                        val dbSource = loadFromDB()
//                        dbSource.subscribeOn(Schedulers.computation())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .take(1)
//                            .subscribe {
//                                dbSource.unsubscribeOn(Schedulers.io())
//                                result.onNext(Resource.Success(it))
//                            }
//                    }
//                    is ApiResponse.Error -> {
//                        onFetchFailed()
//                        result.onNext(Resource.Error(response.errorMessage, null))
//                    }
//                }
//            }
//        mCompositeDisposable.add(response)
//    }
//
//    fun asFlowable(): Flowable<Resource<ResultType>> =
//        result.toFlowable(BackpressureStrategy.BUFFER)
}