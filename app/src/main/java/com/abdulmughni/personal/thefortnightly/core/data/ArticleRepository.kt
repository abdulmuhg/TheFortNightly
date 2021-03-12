package com.abdulmughni.personal.thefortnightly.core.data

import com.abdulmughni.personal.thefortnightly.core.data.source.local.LocalDataSource
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.RemoteDataSource
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.response.ResultsItem
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.core.domain.repository.IArticleRepository
import com.abdulmughni.personal.thefortnightly.core.utils.AppExecutors
import com.abdulmughni.personal.thefortnightly.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IArticleRepository {

//    companion object {
//        @Volatile
//        private var instance: ArticleRepository? = null
//
//        fun getInstance(
//            remoteData: RemoteDataSource,
//            localData: LocalDataSource,
//            appExecutors: AppExecutors
//        ): ArticleRepository =
//            instance ?: synchronized(this) {
//                instance ?: ArticleRepository(remoteData, localData, appExecutors)
//            }
//    }

    override fun getAllArticle(): Flow<Resource<List<Article>>> =
        object : NetworkBoundResource<List<Article>, List<ResultsItem>>(appExecutors) {

            override fun loadFromDB(): Flow<List<Article>> {
                return localDataSource.getAllArticle().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Article>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ResultsItem>>> =
                remoteDataSource.getAllArticle()

            override suspend fun saveCallResult(data: List<ResultsItem>) {
                val articleList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertArticle(articleList)
            }
        }.asFlow()

    override fun getBookmarkedArticle(): Flow<List<Article>> {
        return localDataSource.getAllBookmarkedArticle().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun updateBookmarkArticle(article: Article, state: Boolean) {
        val bookmarkEntity = DataMapper.mapDomainToEntity(article)
        appExecutors.diskIO()
            .execute { localDataSource.updateBookmarkArticle(bookmarkEntity, state) }
    }
}