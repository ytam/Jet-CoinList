package io.github.ytam.jetcoinlist.navigation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("main_screen")
    object CoinDetailsScreen : Screen("details_screen")
}
