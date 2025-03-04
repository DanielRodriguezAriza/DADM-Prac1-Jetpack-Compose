package com.example.prac1

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.IOException

/*
class TriviaViewModel() : ViewModel() {
    var questionTable by mutableStateOf<QuestionTable?>(null)
    var str by mutableStateOf("")

    init {
        // questionTable = LoadQuestions() ?: QuestionTable(mapOf())
    }

    private fun LoadQuestions() : QuestionTable? {
        return try {
            val inputStream = getApplication<Application>().assets.open("questions.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            null
        }
    }
}
*/
