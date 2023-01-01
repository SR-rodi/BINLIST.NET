package com.example.binlistnet.feater_search_bin.domain

import com.example.binlistnet.core.database.UserInfoEntity
import com.example.binlistnet.feater_search_bin.data.dto.Bank
import com.example.binlistnet.feater_search_bin.data.dto.Country
import com.example.binlistnet.feater_search_bin.data.dto.CurdNumber

interface BINInfo {
    val bank: Bank
    val brand: String?
    val country: Country
    val cardNumber: CurdNumber
    val prepaid: Boolean
    val scheme: String
    val type: String?

fun toUserInfoEntity(bin:String) =
    UserInfoEntity(bank.name,country.latitude?.toInt(),country.longitude?.toInt(),bank.phone,bank.url,bin)
}
