package com.maintain.utcwh.api

import android.content.Context
import com.google.gson.JsonArray
import com.maintain.utcwh.JsonProvider
import com.maintain.utcwh.data.APIs
import com.maintain.utcwh.data.bodies.User
import java.lang.Exception
import javax.inject.Inject

class FakeApiService @Inject constructor(var context: Context) : APIs {

    var failUserApi: Boolean = false
    var wrongResponse: Boolean = false

    companion object {
        private const val USER_JSON = "user.json"
    }

    override suspend fun sampleGet(): List<User> {
        if (failUserApi) throw Exception("Api failed")

//        var response = JsonProvider.ReadJSONFromAssets(context = context, USER_JSON)

        var fakeResponse: List<User> = JsonProvider.objectFromJsonFileWithType("")

        if (wrongResponse) return ArrayList<User>()

        return fakeResponse
    }
}