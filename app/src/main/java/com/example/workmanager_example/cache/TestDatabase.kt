package com.example.workmanager_example.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TestEntity::class],version = 1)
abstract class TestDatabase: RoomDatabase() {
    abstract fun testDao(): TestDao

    companion object {
        @Volatile
        private var instance: TestDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TestDatabase::class.java,
                "article_db.db"
            ).build()
    }
}
