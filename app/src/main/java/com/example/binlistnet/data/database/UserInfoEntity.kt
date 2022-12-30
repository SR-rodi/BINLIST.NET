package com.example.binlistnet.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.binlistnet.data.model.UserInfoSmall

@Entity(tableName = "user_info")
class UserInfoEntity(
    @ColumnInfo(name = "bank_name")
    val bankName: String?,
    @ColumnInfo(name = "latitude")
    val latitude: Int?,
    @ColumnInfo(name = "longitude")
    val longitude: Int?,
    val bankPhone: String?,
    @ColumnInfo(name = "bank_url")
    val bankUrl: String?,
    @ColumnInfo(name = "bin")
    @PrimaryKey
    val bin:String,
){
    fun toUserInfoSmall() = UserInfoSmall(bankName,latitude,longitude,bankPhone,bankUrl,bin)
}