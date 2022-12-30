package com.example.binlistnet.di

import com.example.binlistnet.data.repository.BinDataBaseRepositoryImpl
import com.example.binlistnet.data.repository.BinUseCaseImpl
import com.example.binlistnet.domain.BinDataBaseRepository
import com.example.binlistnet.domain.BinUseCase
import org.koin.dsl.module

val  repositoryModule = module {
    single <BinUseCase> { BinUseCaseImpl(get()) }
    single <BinDataBaseRepository> { BinDataBaseRepositoryImpl(get()) }
}