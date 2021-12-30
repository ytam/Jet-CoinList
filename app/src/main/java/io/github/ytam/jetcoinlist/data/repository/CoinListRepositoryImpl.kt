package io.github.ytam.jetcoinlist.data.repository

import io.github.ytam.jetcoinlist.data.remote.response.CoinDetailsResponse
import io.github.ytam.jetcoinlist.data.remote.response.CoinItemResponse
import io.github.ytam.jetcoinlist.data.remote.service.CoinListApi
import io.github.ytam.jetcoinlist.domain.repository.CoinListRepository
import javax.inject.Inject

class CoinListRepositoryImpl @Inject constructor(
    private val api: CoinListApi
) : CoinListRepository {

    override suspend fun getCoinList(): List<CoinItemResponse> = api.getCoinList()

    override suspend fun getCoinDetailsById(id: String): CoinDetailsResponse =
        api.getCoinDetailsById(id)
}
