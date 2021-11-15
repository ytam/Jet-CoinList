package io.github.ytam.coinlist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import io.github.ytam.coinlist.navigation.Navigation
import io.github.ytam.coinlist.ui.theme.CoinListTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinListTheme {

                Navigation()
            }
        }
    }
}