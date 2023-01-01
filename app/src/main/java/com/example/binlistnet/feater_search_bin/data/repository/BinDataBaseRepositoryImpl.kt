package com.example.binlistnet.feater_search_bin.data.repository

import com.example.binlistnet.core.database.UserDao
import com.example.binlistnet.core.database.UserInfoEntity
import com.example.binlistnet.feater_search_bin.domain.BinDataBaseRepository

class BinDataBaseRepositoryImpl(private val dao: UserDao): BinDataBaseRepository {

    override suspend fun addData(data: UserInfoEntity)= dao.insert(data)

    override suspend fun clearDatabase()=dao.clearDatabase()

    override fun getAllData() = dao.getData()
}