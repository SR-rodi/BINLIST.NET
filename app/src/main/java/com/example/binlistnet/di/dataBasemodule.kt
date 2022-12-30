package com.example.binlistnet.di

import androidx.room.Room
import com.example.binlistnet.data.database.AppDataBase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataBaseModule = module {
    single(named("BIN_List")) {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            "BIN_List"
        ).build()
    }

    single {
        get<AppDataBase>(named("BIN_List")).getUserDao()
    }
}