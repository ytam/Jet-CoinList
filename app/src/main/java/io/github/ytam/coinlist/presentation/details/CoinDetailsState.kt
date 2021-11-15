package io.github.ytam.coinlist.presentation.details

import io.github.ytam.coinlist.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val data: CoinDetails? = null,
    val errorMessage: String = ""
)