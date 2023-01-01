package com.example.binlistnet.core.basemodel.base_view_model

import com.example.binlistnet.feater_search_bin.data.model.UserInfo
import com.example.binlistnet.feater_search_bin.data.model.UserInfoSmall
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseStartViewModel: BaseViewModel() {

    val _userInfo = MutableSharedFlow<UserInfo>()
    val userInfo = _userInfo.asSharedFlow()

    val _history = MutableSharedFlow<List<UserInfoSmall>>()
    val history = _history.asSharedFlow()

    init {
        getHistory()
    }

    abstract fun getHistory()
}