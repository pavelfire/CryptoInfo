package com.vk.directop.cryptoinfo.domain.usecase.getcoins

import com.vk.directop.cryptoinfo.common.Resource
import com.vk.directop.cryptoinfo.data.remote.dto.toCoin
import com.vk.directop.cryptoinfo.domain.model.Coin
import com.vk.directop.cryptoinfo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }
}