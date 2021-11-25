package io.github.ytam.jetcoinlist.presentation.list

import io.github.ytam.jetcoinlist.domain.model.CoinItem

data class CoinListState(
    val isLoading: Boolean = false,
    val data: List<CoinItem> = emptyList(),
    val errorMessage: String = ""
)
