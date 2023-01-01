package com.example.binlistnet.feater_search_bin.domain

import com.example.binlistnet.core.database.UserInfoEntity

interface BinInfoSmall {

    val bankName: String?
    val latitude: Int?
    val longitude: Int?
    val bankPhone: String?
    val bankUrl: String?
    val bin: String

    fun toEntity() = UserInfoEntity(bankName, latitude, longitude, bankPhone, bankUrl, bin)
}