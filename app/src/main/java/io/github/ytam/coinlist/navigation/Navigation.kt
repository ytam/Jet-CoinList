package io.github.ytam.coinlist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.ytam.coinlist.presentation.details.CoinDetailsScreen
import io.github.ytam.coinlist.presentation.list.CoinListScreen
import io.github.ytam.coinlist.presentation.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen(navController)
        }
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen(navController)
        }
        composable(
            route = Screen.CoinDetailsScreen.route + "/{coinId}"
        ) {
            CoinDetailsScreen(navController)
        }
    }
}
