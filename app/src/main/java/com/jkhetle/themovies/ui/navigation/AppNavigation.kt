package com.jkhetle.themovies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jkhetle.themovies.ui.screens.DetailsScreen
import com.jkhetle.themovies.ui.screens.HomeScreen

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navController, hiltViewModel())
        }

        composable(
            route = "details/{movieId}",
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.StringType
                    defaultValue = "0"
                },
            ),
        ) {
                backStackEntry ->
            backStackEntry.arguments?.getString("movieId")?.let {
                DetailsScreen(navController, movieId = it, hiltViewModel())
            }
        }

    }
}
