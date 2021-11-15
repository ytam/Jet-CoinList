package io.github.ytam.coinlist.domain.repository

import io.github.ytam.coinlist.data.remote.response.CoinDetailsResponse
import io.github.ytam.coinlist.data.remote.response.CoinItemResponse

interface CoinListRepository {

    suspend fun getCoinList(): List<CoinItemResponse>

    suspend fun getCoinDetailsById(id: String): CoinDetailsResponse
}