package dev.giuliopime.jetpackdemos.demos.colorpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.giuliopime.jetpackdemos.demos.colorpicker.ColorPickerDialog
import timber.log.Timber

/**
 * Color strings should be formatted as hex color values (#000000)
 **/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorPickerScreen() {
    var show by remember { mutableStateOf(false) }
    var color by remember { mutableStateOf("#000000") }

    if (show) {
        ColorPickerDialog(
            initialColor = "#AAAAAA",
            colors = listOf("#FF0000", "#00FF00", "#0000FF"),
            onChoice = {
                Timber.i("Color selected $it")
                color = it
                show = false
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ColorPicker Demo",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 12.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Button(
                onClick = {
                    show = true
                }
            ) {
                Text(
                    text = "Show",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(color.toColor(Color.White))
            )
        }
    }
}