package com.abdulmughni.personal.thefortnightly.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdulmughni.personal.thefortnightly.core.data.source.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun articleDao(): ArticleDao

//    companion object {
//        @Volatile
//        private var INSTANCE: ArticleDatabase? = null
//
//        fun getInstance(context: Context): ArticleDatabase =
//            INSTANCE ?: synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ArticleDatabase::class.java,
//                    "Article.db"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//    }
}