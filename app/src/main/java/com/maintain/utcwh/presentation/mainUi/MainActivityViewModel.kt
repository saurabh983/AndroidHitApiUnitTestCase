package com.maintain.utcwh.presentation.mainUi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonArray
import com.maintain.utcwh.data.bodies.User
import com.maintain.utcwh.data.repository.ApiRepository
import com.maintain.utcwh.domain.SampleUseCase
import com.maintain.utcwh.presentation.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val apiRepository: ApiRepository): ViewModel(){

    private val _userFlow = MutableStateFlow<State<List<User>>>(State.Loading())
    val userFlow: StateFlow<State<List<User>>> = _userFlow

    fun loadUserData() {
        viewModelScope.launch {
            apiRepository.getUser()
                .catch { exception ->
                    _userFlow.value = State.Error(exception.message)
                }
                .collect {
                    _userFlow.value = State.Success(it)
                }
        }
    }

}