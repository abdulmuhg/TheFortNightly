package com.abdulmughni.personal.thefortnightly.di

import com.abdulmughni.personal.thefortnightly.bookmark.BookmarkFragment
import com.abdulmughni.personal.thefortnightly.core.di.CoreComponent
import com.abdulmughni.personal.thefortnightly.detail.DetailActivity
import com.abdulmughni.personal.thefortnightly.detail.DetailFragment
import com.abdulmughni.personal.thefortnightly.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: BookmarkFragment)
    fun inject(activity: DetailActivity)
    fun inject(activity: DetailFragment)
}