package io.github.ytam.jetcoinlist.data.remote.service

import io.github.ytam.jetcoinlist.data.remote.response.CoinDetailsResponse
import io.github.ytam.jetcoinlist.data.remote.response.CoinItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinListApi {

    @GET("/v1/coins")
    suspend fun getCoinList(): List<CoinItemResponse>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetailsById(@Path("coinId") coinId: String): CoinDetailsResponse
}
