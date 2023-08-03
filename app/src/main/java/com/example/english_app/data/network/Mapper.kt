package com.example.english_app.data.network

import android.content.Context
import com.example.english_app.data.model.WordEntity
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

fun DataToEntity(context: Context):List<WordEntity>
{

    val words: ArrayList<WordEntity> = arrayListOf()
    try {
        val jsonObject = JSONObject(JsonDataFromAsset("english_words.json", context))
        val jsonArray = jsonObject.getJSONArray("words")
        for (i in 0 until jsonArray.length()) {
            val wordData = jsonArray.getJSONObject(i)
            val word=WordEntity(wordData.getLong("id"),wordData.getString("word"),wordData.getString("meaning"),wordData.getString("image"))
            words.add(word)
        }
    } catch (e: JSONException) {
        e.printStackTrace()
    }
    return words
}


private fun JsonDataFromAsset(fileName: String, context: Context): String? {
    var json: String? = null
    try {
        //val reader = BufferedReader(InputStreamReader(context.assets.open(fileName), "UTF-8"))
        val inputStream: InputStream = context.assets.open(fileName)
        val sizeOfFile: Int = inputStream.available()
        val bufferData = ByteArray(sizeOfFile)
        inputStream.read(bufferData)
        inputStream.close()
        json = String(bufferData, Charsets.UTF_8)
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
    return json
}