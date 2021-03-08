package com.abdulmughni.personal.thefortnightly.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.abdulmughni.personal.thefortnightly.core.data.source.local.LocalDataSource
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.RemoteDataSource
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.ResultsItem
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.core.domain.repository.IArticleRepository
import com.abdulmughni.personal.thefortnightly.core.utils.AppExecutors
import com.abdulmughni.personal.thefortnightly.core.utils.DataMapper

class ArticleRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IArticleRepository {
    companion object {
        @Volatile
        private var instance: ArticleRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): ArticleRepository =
            instance ?: synchronized(this) {
                instance ?: ArticleRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllArticle(): LiveData<Resource<List<Article>>> =
        object : NetworkBoundResource<List<Article>, List<ResultsItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Article>> {
                return Transformations.map(localDataSource.getAllArticle()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun saveCallResult(data: List<ResultsItem>) {
                val articleList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertArticle(articleList)
            }

            override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> =
                remoteDataSource.getAllArticle()

            override fun shouldFetch(data: List<Article>?): Boolean =
                data == null || data.isEmpty()

        }.asLiveData()

    override fun getBookmarkedArticle(): LiveData<List<Article>> {
        return Transformations.map(localDataSource.getAllBookmarkedArticle()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun updateBookmarkArticle(article: Article, state: Boolean) {
        TODO("Not yet implemented")
    }

    fun setBookmarkArticle(article: Article, state: Boolean) {
        val bookmarkEntity = DataMapper.mapDomainToEntity(article)
        appExecutors.diskIO()
            .execute { localDataSource.updateBookmarkArticle(bookmarkEntity, state) }
    }
}