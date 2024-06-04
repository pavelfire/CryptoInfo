package com.vk.directop.cryptoinfo.presentation.coindetail

import com.vk.directop.cryptoinfo.domain.model.Coin
import com.vk.directop.cryptoinfo.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
