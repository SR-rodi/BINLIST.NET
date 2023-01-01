package com.example.binlistnet.feater_search_bin.domain

import com.example.binlistnet.feater_search_bin.data.model.UserInfo

interface BinUseCase {
    suspend fun getInfoUserByBin(bin: String): UserInfo
}