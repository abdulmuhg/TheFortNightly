package com.abdulmughni.personal.thefortnightly.core.di

//
//object Injection {
//
//    private fun provideRepository(context: Context): IArticleRepository {
//        val database = ArticleDatabase.getInstance(context)
//
//        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
//        val localDataSource = LocalDataSource.getInstance(database.articleDao())
//        val appExecutors = AppExecutors()
//
//        return ArticleRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
//    }
//
//    fun provideArticleUseCase(context: Context): ArticleUseCase {
//        val repository = provideRepository(context)
//        return ArticleInteractor(repository)
//    }
//}
