package com.example.binlistnet.data.dto

import com.example.binlistnet.data.model.UserInfo

class UserInfoDto(
    private val bank: Bank,
    private val brand: String?,
    private val country: Country,
    private val number: CurdNumber,
    private val prepaid: Boolean,
    private val scheme: String,
    private val type: String?
) {
    fun toUserInfo() = UserInfo(bank, brand, country, number, prepaid, scheme, type)
}

