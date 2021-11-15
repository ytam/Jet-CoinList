package io.github.ytam.coinlist.domain.model

data class CoinItem(
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)