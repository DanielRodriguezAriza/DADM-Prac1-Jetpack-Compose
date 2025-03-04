package com.example.prac1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prac1.ui.theme.Prac1Theme
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.IOException
import java.util.Dictionary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prac1Theme {
                TriviaApp(
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun TriviaApp(
    modifier : Modifier = Modifier
) {

    var currentScreen by rememberSaveable { mutableStateOf(value = "WelcomeScreen") }
    var currentMode by rememberSaveable { mutableStateOf(value = "") }

    var currentQuestion by rememberSaveable { mutableStateOf(value = 0) }
    var totalQuestions by rememberSaveable { mutableStateOf(value = 0) }

    val questionTable : QuestionTable = GetDefaultQuestionTable()

    var score by rememberSaveable { mutableStateOf(value = 0) }

    var lastWasCorrect by rememberSaveable { mutableStateOf(value = false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Surface(
            modifier = modifier.padding(innerPadding)
        ) {
            when (currentScreen) {
                "WelcomeScreen" -> {
                    WelcomeScreen(
                        modifier = modifier,
                        onClickContinue = {
                            currentScreen = "MainMenu"
                        }
                    )
                }

                "MainMenu" -> {
                    MainMenu(
                        modifier = modifier,
                        onClickPlay = {
                            currentScreen = "ModeSelectMenu"
                        },
                        onClickSettings = {
                            currentScreen = "SettingsMenu"
                        },
                        onClickReturn = {
                            currentScreen = "WelcomeScreen"
                        }
                    )
                }

                "SettingsMenu" -> {
                    SettingsMenu(
                        modifier = modifier,
                        onClickReturn = {
                            currentScreen = "MainMenu"
                        }
                    )
                }

                "ModeSelectMenu" -> {
                    ModeSelectMenu(
                        modifier = modifier,
                        questionTable = questionTable!!,
                        onClickReturn = {
                            currentScreen = "MainMenu"
                        },
                        onClickMode = { mode : String ->
                            currentMode = mode
                            currentQuestion = 0
                            totalQuestions = 10
                            score = 0
                            currentScreen = "PlayScreen"
                        }
                    )
                }

                "PlayScreen" -> {
                    PlayScreen(
                        modifier = modifier,

                        questionTable = questionTable!!,
                        currentQuestion = currentQuestion,
                        totalQuestions =  totalQuestions,
                        topicKey = currentMode,

                        onQuestionSelected = { isCorrect->
                            lastWasCorrect = isCorrect
                            if(isCorrect)
                            {
                                score += 100
                            }
                            else
                            {
                                score -= 10
                            }
                            currentQuestion += 1
                            currentScreen = "CorrectWrongScreen"
                        },

                        onGameFinished = {
                            currentScreen = "ScoreScreen"
                        }
                    )
                }

                "ScoreScreen" -> {
                    ScoreScreen(
                        modifier = modifier,
                        score = score,
                        onClickContinue = {
                            currentScreen = "MainMenu"
                        }
                    )
                }

                "CorrectWrongScreen" -> {
                    CorrectWrongScreen(
                        modifier = modifier,
                        isCorrect = lastWasCorrect,
                        onClickContinue = {
                            currentScreen = "PlayScreen"
                        }
                    )
                }

                else -> {
                    currentScreen = "WelcomeScreen"
                }
            }
        }
    }

    /*
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(10.dp)
        ) {
            TriviaHeader(
                text = "Hello there!"
            )
            TriviaText(
                text = "Hello, bitch!!!"
            )
        }
    }
    */
}

// Default Content (Disabled for now)
/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prac1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Prac1Theme {
        Greeting("Android")
    }
}
*/
