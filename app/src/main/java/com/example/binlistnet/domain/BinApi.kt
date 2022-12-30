package com.example.binlistnet.domain

import com.example.binlistnet.data.dto.UserInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {

    @GET("{bin}")
    suspend fun getUserInfoByBIN( @Path("bin") bin: String): UserInfoDto

}