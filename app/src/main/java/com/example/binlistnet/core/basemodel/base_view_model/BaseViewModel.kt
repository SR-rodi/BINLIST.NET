package com.example.binlistnet.core.basemodel.base_view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.binlistnet.core.state.LoadState
import kotlinx.coroutines.CoroutineExceptionHandler

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {

    protected val _loadState = MutableStateFlow(LoadState.START)
    val loadState = _loadState.asStateFlow()

    val handler = CoroutineExceptionHandler { _, T ->
        Log.e("Kart", "${T.message}")
        _loadState.value = LoadState.ERROR.apply { message = T.message ?: ERROR_TEXT }
    }

    companion object {
        const val ERROR_TEXT = "Error"
        const val INPUT_FIELD = "Input field is empty"
    }
}