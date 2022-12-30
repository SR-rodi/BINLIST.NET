package com.example.binlistnet.data.repository

import com.example.binlistnet.data.database.UserDao
import com.example.binlistnet.data.database.UserInfoEntity
import com.example.binlistnet.domain.BinDataBaseRepository

class BinDataBaseRepositoryImpl(private val dao: UserDao):BinDataBaseRepository {

    override suspend fun addData(data: UserInfoEntity)= dao.insert(data)

    override suspend fun clearDatabase()=dao.clearDatabase()

    override fun getAllData() = dao.getData()
}