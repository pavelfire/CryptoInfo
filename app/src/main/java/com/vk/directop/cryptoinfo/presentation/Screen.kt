package com.vk.directop.cryptoinfo.presentation

sealed class Screen(val route: String) {
    data object CoinListScreen : Screen("coin_list")
    data object CoinDetailScreen : Screen("coin_detail_screen")
}