package com.example.prac1

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TriviaText (
    modifier : Modifier = Modifier,
    text : String = stringResource(R.string.loc_default_text)
) {
    val sharedStyle = MaterialTheme.typography.headlineSmall.copy(
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.Monospace
    )

    Box {
        Text(
            modifier = modifier
                .offset(x = 3.dp, y = 3.dp),
            text = text,
            style = sharedStyle.copy(
                color = Color(0x88000000)
            )
        )

        Text(
            modifier = modifier,
            text = text,
            style = sharedStyle.copy(
                color = Color.White
            )
        )
    }
}

@Composable
fun TriviaHeader (
    modifier : Modifier = Modifier,
    text : String = stringResource(R.string.loc_default_text)
) {
    val sharedStyle = MaterialTheme.typography.headlineLarge.copy(
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Serif
    )

    Box {
        Text(
            modifier = modifier
                .offset(x = 3.dp, y = 3.dp),
            text = text,
            style = sharedStyle.copy(
                color = Color(0x88000000)
            )
        )

        Text(
            modifier = modifier,
            text = text,
            style = sharedStyle.copy(
                color = Color.White
            )
        )
    }
}

@Composable
fun TriviaCard (
    modifier : Modifier = Modifier,
    call : @Composable ()->Unit
) {
    ElevatedCard (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier.fillMaxWidth().padding(10.dp).shadow(
            elevation = 4.dp,
            shape = MaterialTheme.shapes.medium,
            clip = false
        )
    ) {
        call()
    }
}

@Composable
fun TriviaButton (
    modifier : Modifier = Modifier,
    onClick : ()->Unit,
    call : @Composable ()->Unit,
    callSound : @Composable () -> Unit
) {
    ElevatedButton(
        modifier = modifier.fillMaxWidth().padding(20.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        call()
        callSound()
    }
}

@Composable
fun TriviaButtonText (
    modifier : Modifier = Modifier,
    onClick : ()->Unit,
    text : String
) {
    TriviaButton(
        modifier = modifier
            .padding(
                horizontal = 20.dp,
                vertical = 0.dp
            ),
        onClick = onClick,
        call = {
            TriviaText(
                text = text
            )
        },
        callSound = {
            val ctx = LocalContext.current
            PlaySoundButton(ctx)
        }
    )
}

@Composable
fun TriviaTopic(
    modifier : Modifier = Modifier,
    topicKey : String,
    questionTable : QuestionTable,
    onSelect : (String)->Unit
) {
    ElevatedCard (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier.fillMaxWidth().padding(10.dp).shadow(
            elevation = 4.dp,
            shape = MaterialTheme.shapes.medium,
            clip = false
        )
            .clickable { onSelect(topicKey) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(2.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                // modifier = modifier.weight(1.0f),
            ) {
                TriviaHeader(
                    text = "${questionTable.data[topicKey]?.name}"
                )
            }
            /*
            ElevatedButton(
                onClick = {
                    onSelect(topicKey)
                },
                modifier = modifier.padding(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                TriviaText(
                    text = stringResource(R.string.loc_select)
                )
            }
            */
        }
    }
}

@Composable
fun TriviaQuestion(
    modifier : Modifier = Modifier,
    question : Question,
    questionIndex : Int,
    onSelect : (Int)->Unit
) {
    ElevatedCard (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier.fillMaxWidth().padding(10.dp).shadow(
            elevation = 4.dp,
            shape = MaterialTheme.shapes.medium,
            clip = false
        )
            .clickable { onSelect(questionIndex) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(2.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = modifier.padding(5.dp) // .weight(1.0f),
            ) {
                TriviaHeader(
                    text = "Opción ${questionIndex + 1}:"
                )
                TriviaText(
                    text = question.options[questionIndex]
                )
            }
            /*
            ElevatedButton(
                onClick = {
                    onSelect(questionIndex)
                },
                modifier = modifier.padding(20.dp)
            ) {
                Text(
                    text = ""
                )
            }
            */
        }
    }
}

@Composable
fun PlaySoundButton(context : Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.button)
    mediaPlayer.start()
}

@Composable
fun PlaySoundError(context : Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.error)
    mediaPlayer.start()
}

@Composable
fun PlaySoundCorrect(context : Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.correct)
    mediaPlayer.start()
}
