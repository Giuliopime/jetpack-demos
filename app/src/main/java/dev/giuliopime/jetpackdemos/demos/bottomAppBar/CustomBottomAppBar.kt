package dev.giuliopime.jetpackdemos.demos.bottomAppBar

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomBottomAppBar(
    pages: List<BottomAppBarPage>,
    selectedPage: String,
    onPageClicked: (page: String) -> Unit
) {
    NavigationBar(
        windowInsets = WindowInsets.navigationBars
    ) {
        pages.forEach { page ->
            NavigationBarItem(
                selected = selectedPage == page.route,
                onClick = {
                    onPageClicked(page.route)
                },
                icon = {
                    Icon(
                        imageVector = if (selectedPage == page.route) page.iconSelected else page.icon,
                        contentDescription = page.iconDescription,
                    )
                },
                label = {
                    Text(
                        text = page.name,
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}