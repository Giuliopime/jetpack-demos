package dev.giuliopime.jetpackdemos.demos.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import dev.giuliopime.jetpackdemos.demos.bottomsheet.BetterModalBottomSheet
import dev.giuliopime.jetpackdemos.demos.bottomsheet.DefaultModalBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetScreen() {
    var showDefault by remember { mutableStateOf(false) }
    var showCustom by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ModalBottomSheet Demo",
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
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            Button(
                onClick = {
                    showDefault = true
                }
            ) {
                Text(
                    text = "Show default",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Button(
                onClick = {
                    showCustom = true
                }
            ) {
                Text(
                    text = "Show custom",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        DefaultModalBottomSheet(
            showSheet = showDefault,
            onDismissRequest = { showDefault = false }
        ) {
            repeat(5) {
                Text(
                    text = "Default $it",
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                )
            }
        }

        BetterModalBottomSheet(
            showSheet = showCustom,
            onDismissRequest = { showCustom = false }
        ) {
            repeat(5) {
                Text(
                    text = "Custom $it",
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                )
            }
        }
    }
}