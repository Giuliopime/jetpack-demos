package dev.giuliopime.jetpackdemos.demos.bottomAppBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountPage() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Account",
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Timber.i("Clicked")
                },
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add")
            }
        },
        // This removes the system navigation bar padding which we have already handled in the top level screen
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(NavigationBarDefaults.windowInsets)
    ) { paddingValues ->  
        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(
                space = 4.dp
            )
        ) {
            items(50) {
                Text(text = "Item $it")
            }
        }
    }
}