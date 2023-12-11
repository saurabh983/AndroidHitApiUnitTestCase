package com.maintain.utcwh.presentation

sealed class State<T>(val data: T? = null, val error: String? = null) {
    class Success<T>(data: T?) : State<T>(data)
    class Loading<T> : State<T>()
    class Error<T>(message: String?) : State<T>(error = message)
}