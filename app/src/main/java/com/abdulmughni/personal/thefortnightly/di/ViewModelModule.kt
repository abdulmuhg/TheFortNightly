package com.abdulmughni.personal.thefortnightly.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdulmughni.personal.thefortnightly.bookmark.BookmarkViewModel
import com.abdulmughni.personal.thefortnightly.core.ui.ViewModelFactory
import com.abdulmughni.personal.thefortnightly.detail.DetailViewModel
import com.abdulmughni.personal.thefortnightly.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BookmarkViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: BookmarkViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}