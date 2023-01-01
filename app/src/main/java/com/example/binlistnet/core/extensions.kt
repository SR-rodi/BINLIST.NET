package com.example.binlistnet.core

import com.example.binlistnet.core.database.UserInfoEntity

fun List<UserInfoEntity>.toListUserInfoSmall() = this.map { info-> info.toUserInfoSmall()  }