package com.example.binlistnet.data.repository

import com.example.binlistnet.domain.BinApi
import com.example.binlistnet.domain.BinUseCase

class BinUseCaseImpl(private val binApi: BinApi):BinUseCase {

    override suspend fun getInfoUserByBin(bin: String) = binApi.getUserInfoByBIN(bin).toUserInfo()
}