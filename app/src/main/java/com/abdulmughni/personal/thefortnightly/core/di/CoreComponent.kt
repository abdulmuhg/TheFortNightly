package com.abdulmughni.personal.thefortnightly.core.di

import android.content.Context
import com.abdulmughni.personal.thefortnightly.core.domain.repository.IArticleRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): IArticleRepository
}
