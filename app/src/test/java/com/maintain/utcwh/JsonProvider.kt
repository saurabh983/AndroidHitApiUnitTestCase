package com.maintain.utcwh

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.maintain.utcwh.data.bodies.User
import java.io.BufferedReader
import java.io.InputStreamReader

object JsonProvider {


    fun objectFromJsonFileWithType(filePath: String): List<User> {

        val myType = object : TypeToken<List<User>>() {}.type
        val jsonString= "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Leanne Graham\",\n" +
                "    \"username\": \"Bret\",\n" +
                "    \"email\": \"Sincere@april.biz\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Kulas Light\",\n" +
                "      \"suite\": \"Apt. 556\",\n" +
                "      \"city\": \"Gwenborough\",\n" +
                "      \"zipcode\": \"92998-3874\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-37.3159\",\n" +
                "        \"lng\": \"81.1496\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"phone\": \"1-770-736-8031 x56442\",\n" +
                "    \"website\": \"hildegard.org\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Romaguera-Crona\",\n" +
                "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                "      \"bs\": \"harness real-time e-markets\"\n" +
                "    }\n" +
                "  }\n" +
                "]"
        val logs = Gson().fromJson<List<User>>(jsonString, myType)
        return logs
    }

    //Giving file not found error
    fun fileAsString(filePath: String): String = this::class.java
        .getResourceAsStream(filePath)!!
        .bufferedReader()
        .use { it.readText() }

    fun ReadJSONFromAssets(context: Context, path: String): String {
        return context.assets.open(path).bufferedReader().use { it.readText() }
    }
}