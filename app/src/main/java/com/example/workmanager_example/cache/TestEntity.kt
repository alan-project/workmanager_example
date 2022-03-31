package com.example.workmanager_example.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "testEntity")
data class TestEntity(
    @PrimaryKey
    val id:Int = 0
)
