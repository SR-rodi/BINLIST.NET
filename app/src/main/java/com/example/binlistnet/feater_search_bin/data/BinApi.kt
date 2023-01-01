package com.example.binlistnet.feater_search_bin.data

import com.example.binlistnet.feater_search_bin.data.dto.UserInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {

    @GET("{bin}")
    suspend fun getUserInfoByBIN( @Path("bin") bin: String): UserInfoDto

}