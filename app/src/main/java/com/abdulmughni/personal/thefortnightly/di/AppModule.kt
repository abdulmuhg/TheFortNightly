package com.abdulmughni.personal.thefortnightly.di

import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleInteractor
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: ArticleInteractor): ArticleUseCase

}