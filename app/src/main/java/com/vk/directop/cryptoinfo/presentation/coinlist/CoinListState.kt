package com.vk.directop.cryptoinfo.presentation.coinlist

import com.vk.directop.cryptoinfo.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
