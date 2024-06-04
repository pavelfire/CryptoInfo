package com.vk.directop.cryptoinfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vk.directop.cryptoinfo.presentation.coindetail.CoinDetailScreen
import com.vk.directop.cryptoinfo.presentation.coinlist.CoinListScreen
import com.vk.directop.cryptoinfo.presentation.ui.theme.CryptoInfoTheme
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoInfoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }
                        composable(Screen.CoinDetailScreen.route + "/{coinId}") {
                            CoinDetailScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

