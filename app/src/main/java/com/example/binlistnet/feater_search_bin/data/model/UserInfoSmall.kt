package com.example.binlistnet.feater_search_bin.data.model

import com.example.binlistnet.feater_search_bin.domain.BinInfoSmall

class UserInfoSmall(
    override val bankName: String?,
    override val latitude: Int?,
    override val longitude: Int?,
    override val bankPhone: String?,
    override val bankUrl: String?,
    override val bin: String,
) : BinInfoSmall