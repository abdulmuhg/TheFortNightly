package com.abdulmughni.personal.thefortnightly.core.di

import com.abdulmughni.personal.thefortnightly.core.data.ArticleRepository
import com.abdulmughni.personal.thefortnightly.core.domain.repository.IArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(articleRepository: ArticleRepository): IArticleRepository

}