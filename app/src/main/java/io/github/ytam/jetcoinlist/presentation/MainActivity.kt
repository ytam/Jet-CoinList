package io.github.ytam.jetcoinlist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import io.github.ytam.jetcoinlist.navigation.Navigation
import io.github.ytam.jetcoinlist.ui.theme.CoinListTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CoinListTheme {
                Navigation()
            }
        }
    }
}
