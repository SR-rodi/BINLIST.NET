package com.example.binlistnet.feater_search_bin.data.repository

import com.example.binlistnet.feater_search_bin.data.BinApi
import com.example.binlistnet.feater_search_bin.domain.BinUseCase

class BinUseCaseImpl(private val binApi: BinApi): BinUseCase {

    override suspend fun getInfoUserByBin(bin: String) = binApi.getUserInfoByBIN(bin).toUserInfo()
}