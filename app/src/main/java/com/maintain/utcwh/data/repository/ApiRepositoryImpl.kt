package com.maintain.utcwh.data.repository

import com.maintain.utcwh.data.APIs
import com.maintain.utcwh.data.bodies.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiRepositoryImpl(private val services: APIs) : ApiRepository {

    override suspend fun getUser(): Flow<List<User>> = flow {
        emit(services.sampleGet())
    }
}