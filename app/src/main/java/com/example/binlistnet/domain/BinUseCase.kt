package com.example.binlistnet.domain

import com.example.binlistnet.data.model.UserInfo

interface BinUseCase {
    suspend fun getInfoUserByBin(bin: String):UserInfo
}