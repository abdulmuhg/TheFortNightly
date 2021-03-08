package com.abdulmughni.personal.thefortnightly.core.di

import android.content.Context
import com.abdulmughni.personal.thefortnightly.core.data.ArticleRepository
import com.abdulmughni.personal.thefortnightly.core.data.source.local.LocalDataSource
import com.abdulmughni.personal.thefortnightly.core.data.source.local.room.ArticleDatabase
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.RemoteDataSource
import com.abdulmughni.personal.thefortnightly.core.data.source.remote.network.ApiConfig
import com.abdulmughni.personal.thefortnightly.core.domain.repository.IArticleRepository
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleInteractor
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase
import com.abdulmughni.personal.thefortnightly.core.utils.AppExecutors

object Injection {

    private fun provideRepository(context: Context): IArticleRepository {
        val database = ArticleDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.articleDao())
        val appExecutors = AppExecutors()

        return ArticleRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideArticleUseCase(context: Context): ArticleUseCase {
        val repository = provideRepository(context)
        return ArticleInteractor(repository)
    }
}
