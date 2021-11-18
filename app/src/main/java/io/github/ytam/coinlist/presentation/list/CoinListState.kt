package io.github.ytam.coinlist.presentation.list

import io.github.ytam.coinlist.domain.model.CoinItem

data class CoinListState(
    val isLoading: Boolean = false,
    val data: List<CoinItem> = emptyList(),
    val errorMessage: String = ""
)
