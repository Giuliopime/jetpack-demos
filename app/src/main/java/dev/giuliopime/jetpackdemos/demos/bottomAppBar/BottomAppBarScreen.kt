package dev.giuliopime.jetpackdemos.demos.bottomAppBar

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomAppBarScreen() {
    val navController = rememberNavController()
    val pages = listOf(BottomAppBarPage.Feed, BottomAppBarPage.Account, BottomAppBarPage.Settings)
    // TODO: Find a way to only rely on the navController
    var selectedPage by remember { mutableStateOf(BottomAppBarPage.Account.route) }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomAppBarPage.Account.route,
            modifier = Modifier.weight(1f)
        ) {
            composable(
                route = BottomAppBarPage.Feed.route,
                enterTransition = {
                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
                }
            ) {
                Text(text = "Feed")
            }

            composable(
                route = BottomAppBarPage.Account.route,
                enterTransition = {
                    if (initialState.destination.route == BottomAppBarPage.Settings.route) {
                        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
                    } else {
                        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
                    }
                },
                exitTransition = {
                    if (targetState.destination.route == BottomAppBarPage.Settings.route) {
                        slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
                    } else {
                        slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
                    }
                }
            ) {
                AccountPage()
            }

            composable(
                route = BottomAppBarPage.Settings.route,
                enterTransition = {
                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
                }
            ) {
                Text(text = "Settings")
            }
        }

        CustomBottomAppBar(
            pages = pages,
            selectedPage = selectedPage,
            onPageClicked = {
                selectedPage = it
                navController.navigate(it) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}