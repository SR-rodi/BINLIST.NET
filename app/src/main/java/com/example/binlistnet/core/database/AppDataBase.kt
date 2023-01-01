package com.example.binlistnet.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserInfoEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}