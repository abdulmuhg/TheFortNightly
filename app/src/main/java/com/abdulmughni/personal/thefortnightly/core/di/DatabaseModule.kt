package com.abdulmughni.personal.thefortnightly.core.di

import android.content.Context
import androidx.room.Room
import com.abdulmughni.personal.thefortnightly.core.data.source.local.room.ArticleDao
import com.abdulmughni.personal.thefortnightly.core.data.source.local.room.ArticleDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): ArticleDatabase = Room.databaseBuilder(
        context,
        ArticleDatabase::class.java, "Tourism.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: ArticleDatabase): ArticleDao = database.articleDao()
}