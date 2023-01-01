package com.example.binlistnet.di

import com.example.binlistnet.feater_search_bin.data.BinApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val retrofitModule = module {
    single(named("BIN_list.NET")) {
        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<BinApi> {
        get<Retrofit>(named("BIN_list.NET")).create()
    }
}