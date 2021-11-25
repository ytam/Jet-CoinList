package io.github.ytam.jetcoinlist.data.remote.response

import io.github.ytam.jetcoinlist.domain.model.CoinItem

data class CoinItemResponse(
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinItemResponse.toCoinItem(): CoinItem {
    return CoinItem(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        type = type
    )
}
