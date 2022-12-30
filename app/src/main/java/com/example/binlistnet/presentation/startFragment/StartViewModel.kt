package com.example.binlistnet.presentation.startFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistnet.data.model.UserInfo
import com.example.binlistnet.data.model.UserInfoSmall
import com.example.binlistnet.data.state.LoadState
import com.example.binlistnet.domain.BinDataBaseRepository
import com.example.binlistnet.domain.BinUseCase
import com.example.binlistnet.tools.toListUserInfoSmall
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class StartViewModel(
    private val binUseCase: BinUseCase,
    private val binDataBaseRepository: BinDataBaseRepository
) : ViewModel() {

    private val _userInfo = MutableSharedFlow<UserInfo>()
    val userInfo = _userInfo.asSharedFlow()

    private val _history = MutableSharedFlow<List<UserInfoSmall>>()
    val history = _history.asSharedFlow()

    private val _loadState = MutableStateFlow(LoadState.START)
    val loadState = _loadState.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, T ->
        Log.e("Kart", "${T.message}")
        _loadState.value = LoadState.ERROR.apply { message = T.message ?: "Error" }
    }

    fun getUserInfo(bin: String?) {
        if (bin != null && bin != "")
            viewModelScope.launch(Dispatchers.IO + handler) {
                _loadState.value = LoadState.LOADING
                val userInfo = binUseCase.getInfoUserByBin(bin)
                _userInfo.emit(userInfo)
                binDataBaseRepository.addData(userInfo.toUserInfoEntity(bin))
                _loadState.value = LoadState.SUCCESS
            } else _loadState.value = LoadState.ERROR.apply { message = "Input field is empty" }
    }

    fun getHistory() {
            binDataBaseRepository.getAllData().onEach {
                _history.emit(it.toListUserInfoSmall())
            }.launchIn(viewModelScope)

    }
}