package com.maintain.utcwh.utils

import com.maintain.utcwh.domain.AuthenticationException
import com.maintain.utcwh.domain.NetworkErrorException
import com.maintain.utcwh.presentation.State
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object Utils {
//    fun resolveError(e: Exception): State.Error {
//        var error = e
//        when(e) {
//            is SocketTimeoutException -> {
//                error = NetworkErrorException(errorMessage = "connection error!")
//            }
//
//            is ConnectException -> {
//                error = NetworkErrorException(errorMessage = "no internet access!")
//            }
//
//            is UnknownHostException -> {
//                error = NetworkErrorException(errorMessage = "no internet access!")
//            }
//        }
//
//        if (e is HttpException){
//            when(e.code()){
//                502 -> {
//                    error = NetworkErrorException(e.code(), "internal error!")
//                }
//                401 -> {
//                    throw AuthenticationException("authentication error!")
//                }
//                400 -> {
//                    error = NetworkErrorException.parseException(e)
//                }
//            }
//        }
//
//        return State.ErrorState(error)
//    }
}