package com.example.binlistnet.di

import com.example.binlistnet.feater_search_bin.data.repository.BinDataBaseRepositoryImpl
import com.example.binlistnet.feater_search_bin.data.repository.BinUseCaseImpl
import com.example.binlistnet.feater_search_bin.domain.BinDataBaseRepository
import com.example.binlistnet.feater_search_bin.domain.BinUseCase
import org.koin.dsl.module

val repositoryModule = module {
    single<BinUseCase> { BinUseCaseImpl(get()) }
    single<BinDataBaseRepository> { BinDataBaseRepositoryImpl(get()) }
}