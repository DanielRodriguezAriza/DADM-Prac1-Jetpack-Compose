package com.example.prac1

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun WelcomeScreen(
    modifier : Modifier = Modifier,
    onClickContinue : () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.tertiary
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TriviaHeader(
                text = stringResource(R.string.loc_game_name)
            )
            TriviaButtonText(
                onClick = onClickContinue,
                text = stringResource(R.string.loc_start)
            )
        }
    }
}

@Composable
fun MainMenu(
    modifier : Modifier = Modifier,
    onClickPlay : ()->Unit,
    onClickSettings : ()->Unit,
    onClickReturn : ()->Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.tertiary
    ){
        Column (
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TriviaHeader(
                text = stringResource(R.string.loc_game_name)
            )

            TriviaButtonText(
                text = stringResource(R.string.loc_play),
                onClick = onClickPlay
            )

            TriviaButtonText(
                text = stringResource(R.string.loc_settings),
                onClick = onClickSettings
            )

            TriviaButtonText(
                text = stringResource(R.string.loc_return),
                onClick = onClickReturn
            )
        }
    }
}

@Composable
fun SettingsMenu(
    modifier : Modifier = Modifier,
    onClickReturn : ()->Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.tertiary
    ){
        Column (
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TriviaHeader(
                text = stringResource(R.string.loc_settings)
            )

            TriviaButtonText(
                text = stringResource(R.string.loc_return),
                onClick = onClickReturn
            )
        }
    }
}

@Composable
fun ModeSelectMenu(
    modifier : Modifier = Modifier,
    questionTable: QuestionTable,
    onClickReturn : ()->Unit,
    onClickMode : (mode : String)->Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.tertiary
    ){
        Column (
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TriviaHeader(
                text = stringResource(R.string.loc_mode_select)
            )

            TriviaButtonText(
                text = stringResource(R.string.loc_return),
                onClick = onClickReturn
            )

            LazyColumn(
                modifier = modifier.padding(10.dp)
            ) {
                items(items = questionTable.data.keys.toList()) {name->
                    TriviaTopic(
                        modifier = modifier.padding(5.dp),
                        topicKey = name,
                        questionTable = questionTable,
                        onSelect = {key->
                            onClickMode(key)
                        }
                    )
                }
            }

        }
    }
}

@Composable
fun PlayScreen(
    modifier : Modifier = Modifier,
    questionTable: QuestionTable,
    topicKey : String,
    currentQuestion : Int,
    totalQuestions : Int,

    /*
    onGameStart : ()->Unit,
    onGameEnd : ()->Unit,
    onQuestionStart : ()->Unit,
    onQuestionEnd : ()->Unit,
    */

    onQuestionSelected : (Boolean)->Unit, // this bool means is correct
    onGameFinished : ()->Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.tertiary
    ){
        if(currentQuestion >= totalQuestions)
        {
            onGameFinished()
        }
        else {
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TriviaHeader(
                    text = "${questionTable.data[topicKey]?.name}"
                )
                TriviaText(
                    text = "${currentQuestion + 1}/$totalQuestions"
                )

                Column (
                    modifier = modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var questionList = questionTable.data[topicKey]?.questions!!
                    val q = questionList[currentQuestion]

                    Text(
                        textAlign = TextAlign.Center,
                        text = q.question,
                        modifier = modifier.align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )

                    for (idx in 0..q.options.count() - 1) {
                        TriviaQuestion(
                            question = q,
                            questionIndex = idx,
                            onSelect = { selectIdx ->
                                onQuestionSelected(selectIdx == q.answer)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ScoreScreen(
    modifier : Modifier = Modifier,
    score : Int,
    onClickContinue : ()->Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.tertiary
    ){
        Column (
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TriviaHeader(
                text = stringResource(R.string.loc_score)
            )

            TriviaText(
                text = "$score"
            )

            TriviaButtonText(
                text = stringResource(R.string.loc_return),
                onClick = onClickContinue
            )
        }
    }
}

@Composable
fun CorrectWrongScreen(
    modifier : Modifier = Modifier,
    isCorrect : Boolean,
    onClickContinue : () -> Unit
) {
    val ctx = LocalContext.current
    val str : String
    val bgColor : Color
    if(isCorrect)
    {
        PlaySoundCorrect(ctx)
        str = stringResource(R.string.loc_correct)
        bgColor = Color.Green
    }
    else
    {
        PlaySoundError(ctx)
        str = stringResource(R.string.loc_wrong)
        bgColor = Color.Red
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = bgColor
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TriviaHeader(
                text = str
            )
            TriviaButtonText(
                onClick = onClickContinue,
                text = stringResource(R.string.loc_continue)
            )
        }
    }
}
