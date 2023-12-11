package com.maintain.utcwh.domain

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.maintain.utcwh.data.APIs
import com.maintain.utcwh.data.bodies.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
//Not in use
class SampleUseCase @Inject constructor(private val apIs: APIs) {

    suspend operator fun invoke(): Flow<List<User>> = flow {
        emit(apIs.sampleGet())
    }
}