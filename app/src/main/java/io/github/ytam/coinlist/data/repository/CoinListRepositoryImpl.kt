package io.github.ytam.coinlist.data.repository

import io.github.ytam.coinlist.data.remote.response.CoinDetailsResponse
import io.github.ytam.coinlist.data.remote.response.CoinItemResponse
import io.github.ytam.coinlist.data.remote.service.CoinListApi
import io.github.ytam.coinlist.domain.repository.CoinListRepository
import javax.inject.Inject

class CoinListRepositoryImpl @Inject constructor(
    private val api: CoinListApi
) : CoinListRepository {

    override suspend fun getCoinList(): List<CoinItemResponse> {
        return api.getCoinList()
    }

    override suspend fun getCoinDetailsById(id: String): CoinDetailsResponse {
        return api.getCoinDetailsById(id)
    }
}
