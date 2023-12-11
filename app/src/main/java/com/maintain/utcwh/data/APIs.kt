package com.maintain.utcwh.data

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.maintain.utcwh.data.bodies.User
import retrofit2.http.GET

interface APIs {

    @GET("users")
    suspend fun sampleGet(): List<User>
}