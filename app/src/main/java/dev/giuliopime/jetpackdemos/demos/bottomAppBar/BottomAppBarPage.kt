package dev.giuliopime.jetpackdemos.demos.bottomAppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/*
 * A standard app would use string resources.
 * This is just for a quick demo
 */
sealed class BottomAppBarPage(
    val route: String,
    val name: String,
    val icon: ImageVector,
    val iconSelected: ImageVector,
    val iconDescription: String
) {
    object Feed : BottomAppBarPage(
        route = "feed",
        name = "feed",
        icon = Icons.Outlined.Home,
        iconSelected = Icons.Filled.Home,
        iconDescription = "feed"
    )
    object Account : BottomAppBarPage(
        route = "account",
        name = "Account",
        icon = Icons.Outlined.AccountCircle,
        iconSelected = Icons.Filled.AccountCircle,
        iconDescription = "account"
    )
    object Settings : BottomAppBarPage(
        route = "settings",
        name = "Settings",
        icon = Icons.Outlined.Settings,
        iconSelected = Icons.Filled.Settings,
        iconDescription = "settings"
    )
}
