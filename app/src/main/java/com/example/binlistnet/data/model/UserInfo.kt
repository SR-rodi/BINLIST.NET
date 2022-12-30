package com.example.binlistnet.data.model

import com.example.binlistnet.data.dto.Bank
import com.example.binlistnet.data.dto.Country
import com.example.binlistnet.data.dto.CurdNumber
import com.example.binlistnet.domain.BINInfo

class UserInfo(
    override val bank: Bank,
    override val brand: String?,
    override val country: Country,
    override val cardNumber: CurdNumber,
    override val prepaid: Boolean,
    override val scheme: String,
    override val type: String?
) : BINInfo