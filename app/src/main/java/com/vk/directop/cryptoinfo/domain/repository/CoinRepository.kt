package com.vk.directop.cryptoinfo.domain.repository

import com.vk.directop.cryptoinfo.data.remote.dto.CoinDetailDto
import com.vk.directop.cryptoinfo.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}