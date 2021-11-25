package io.github.ytam.jetcoinlist.domain.repository

import io.github.ytam.jetcoinlist.data.remote.response.CoinDetailsResponse
import io.github.ytam.jetcoinlist.data.remote.response.CoinItemResponse

interface CoinListRepository {

    suspend fun getCoinList(): List<CoinItemResponse>

    suspend fun getCoinDetailsById(id: String): CoinDetailsResponse
}
