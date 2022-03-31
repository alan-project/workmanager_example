package com.example.workmanager_example.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(testEntity:TestEntity)

    @Query("DELETE FROM testEntity")
    suspend fun deleteAll()
}