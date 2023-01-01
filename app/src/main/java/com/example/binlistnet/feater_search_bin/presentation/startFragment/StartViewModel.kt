package com.example.binlistnet.feater_search_bin.presentation.startFragment

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.binlistnet.core.basemodel.base_view_model.BaseStartViewModel
import com.example.binlistnet.core.state.LoadState
import com.example.binlistnet.feater_search_bin.domain.BinDataBaseRepository
import com.example.binlistnet.feater_search_bin.domain.BinUseCase
import com.example.binlistnet.core.toListUserInfoSmall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class StartViewModel(
    private val binUseCase: BinUseCase,
    private val binDataBaseRepository: BinDataBaseRepository,
) : BaseStartViewModel() {

    init {
        getHistory()
    }

    fun onClickSearchButton(bin: String?) {
        if (bin != null && bin != "")
            viewModelScope.launch(Dispatchers.IO + handler) {
                _loadState.value = LoadState.LOADING
                val userInfo = binUseCase.getInfoUserByBin(bin)
                _userInfo.emit(userInfo)
                binDataBaseRepository.addData(userInfo.toUserInfoEntity(bin))
                _loadState.value = LoadState.SUCCESS
            } else _loadState.value = LoadState.ERROR.apply { message = INPUT_FIELD }
    }

    private fun getHistory() {
        binDataBaseRepository.getAllData().onEach {
            _history.emit(it.toListUserInfoSmall())
        }.launchIn(viewModelScope)
    }

    fun onSwiped(position: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            binDataBaseRepository.deleteItem(_history.value[position].toEntity())
        }
    }
}