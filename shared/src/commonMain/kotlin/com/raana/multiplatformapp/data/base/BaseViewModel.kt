package com.raana.multiplatformapp.data.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

////todo behnam WIP
//abstract class BaseViewModel<STATE>(
//    initialState: STATE
//) : ViewModel() {
//
//    private val _state = MutableStateFlow(initialState)
//    val stateStateFlow = _state.asStateFlow()
//
//    val currentState: STATE
//        get() {
//            return _state.value
//        }
//
//    fun updateState(function: STATE.() -> STATE) {
//        _state.update { function(it) }
//    }
//}