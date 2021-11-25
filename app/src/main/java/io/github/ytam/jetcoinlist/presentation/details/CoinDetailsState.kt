package io.github.ytam.jetcoinlist.presentation.details

import io.github.ytam.jetcoinlist.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val data: CoinDetails? = null,
    val errorMessage: String = ""
)
