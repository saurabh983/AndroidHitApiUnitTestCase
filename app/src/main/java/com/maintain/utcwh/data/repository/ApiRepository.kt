package com.maintain.utcwh.data.repository

import com.maintain.utcwh.data.bodies.User
import kotlinx.coroutines.flow.Flow

interface ApiRepository {

    suspend fun getUser(): Flow<List<User>>
}