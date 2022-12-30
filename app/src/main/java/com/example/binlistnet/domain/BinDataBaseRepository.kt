package com.example.binlistnet.domain

import com.example.binlistnet.data.database.UserInfoEntity
import kotlinx.coroutines.flow.Flow

interface BinDataBaseRepository {

    suspend fun addData(data: UserInfoEntity)

    suspend fun clearDatabase()

    fun getAllData():Flow<List<UserInfoEntity>>
}