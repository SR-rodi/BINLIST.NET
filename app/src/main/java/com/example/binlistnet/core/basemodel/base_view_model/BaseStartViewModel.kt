package com.example.binlistnet.core.basemodel.base_view_model

import com.example.binlistnet.feater_search_bin.data.model.UserInfo
import com.example.binlistnet.feater_search_bin.data.model.UserInfoSmall
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseStartViewModel: BaseViewModel() {

    val _userInfo = MutableSharedFlow<UserInfo>()
    val userInfo = _userInfo.asSharedFlow()

    val _history = MutableStateFlow<List<UserInfoSmall>>(emptyList())
    val history = _history.asStateFlow()

}