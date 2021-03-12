package com.abdulmughni.personal.thefortnightly.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdulmughni.personal.thefortnightly.bookmark.BookmarkViewModel
import com.abdulmughni.personal.thefortnightly.core.domain.usecase.ArticleUseCase
import com.abdulmughni.personal.thefortnightly.detail.DetailViewModel
import com.abdulmughni.personal.thefortnightly.di.AppScope
import com.abdulmughni.personal.thefortnightly.home.HomeViewModel
import javax.inject.Inject
import javax.inject.Provider
@AppScope
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return creator.get() as T
    }
}