package io.github.ytam.jetcoinlist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import dagger.hilt.android.AndroidEntryPoint
import io.github.ytam.jetcoinlist.presentation.navigation.Navigation
import io.github.ytam.jetcoinlist.ui.theme.CoinListTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinListTheme {

                Navigation()
            }
        }
    }
}
