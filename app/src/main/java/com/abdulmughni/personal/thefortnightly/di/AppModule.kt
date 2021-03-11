package com.abdulmughni.personal.thefortnightly.di

import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleInteractor
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: ArticleInteractor): ArticleUseCase

}