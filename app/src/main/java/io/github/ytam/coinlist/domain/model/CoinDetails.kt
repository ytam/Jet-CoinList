package io.github.ytam.coinlist.domain.model

data class CoinDetails(
    val id: String,
    val name: String,
    val description: String,
    val firstDataDate: String,
    val lastDataDate: String,
    val symbol: String,
    val type: String,
    val platform: String
)
