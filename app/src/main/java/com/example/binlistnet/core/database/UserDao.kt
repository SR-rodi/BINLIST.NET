package com.example.binlistnet.core.database

import androidx.room.Dao
import androidx.room.*
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: UserInfoEntity)

    @Query("DELETE FROM user_info")
    suspend fun clearDatabase()

    @Query("SELECT*FROM user_info")
    fun getData(): Flow<List<UserInfoEntity>>
}