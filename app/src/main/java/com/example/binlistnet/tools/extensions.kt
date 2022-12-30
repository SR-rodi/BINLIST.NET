package com.example.binlistnet.tools

import com.example.binlistnet.data.database.UserInfoEntity

fun List<UserInfoEntity>.toListUserInfoSmall() = this.map {info-> info.toUserInfoSmall()  }