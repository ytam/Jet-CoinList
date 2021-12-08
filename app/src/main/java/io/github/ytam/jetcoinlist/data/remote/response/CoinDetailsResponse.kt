package io.github.ytam.jetcoinlist.data.remote.response

import io.github.ytam.jetcoinlist.domain.model.CoinDetails

data class CoinDetailsResponse(
    val id: String,
    val name: String,
    val description: String,
    val firstDataDate: String,
    val lastDataDate: String,
    val symbol: String,
    val type: String
)

fun CoinDetailsResponse.toCoinDetails(): CoinDetails {
    return CoinDetails(
        id = id,
        name = name,
        description = description,
        firstDataDate = firstDataDate,
        lastDataDate = lastDataDate,
        symbol = symbol,
        type = type
    )
}
