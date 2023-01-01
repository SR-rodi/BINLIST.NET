package com.example.binlistnet.feater_search_bin.domain

import com.example.binlistnet.core.database.UserInfoEntity
import kotlinx.coroutines.flow.Flow

interface BinDataBaseRepository {

    suspend fun addData(data: UserInfoEntity)

    suspend fun clearDatabase()

    suspend fun deleteItem(data: UserInfoEntity)

    fun getAllData():Flow<List<UserInfoEntity>>
}