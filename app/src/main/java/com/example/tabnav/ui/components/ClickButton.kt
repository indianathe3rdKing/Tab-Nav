package com.example.tabnav.ui.components

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@Composable
fun ClickButton(){
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    Button(
        onClick = { /*TODO*/ },
        enabled = true,

        modifier = Modifier
            .offset{ IntOffset(offsetX.roundToInt(),offsetY.roundToInt()) }
            .padding(16.dp)
            .requiredSize(50.dp)
            .pointerInput(Unit){
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetY+= dragAmount.y
                    offsetX+= dragAmount.x
                }
            }
    ) {
        Text(
            text = "1",
            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center), // Center both horizontally and vertically
            style = MaterialTheme.typography.bodyMedium // Optional: Adjust text style
        )
    }
}