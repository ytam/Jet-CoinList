package io.github.ytam.jetcoinlist.domain.usecase

import io.github.ytam.jetcoinlist.common.Resource
import io.github.ytam.jetcoinlist.data.remote.response.toCoinItem
import io.github.ytam.jetcoinlist.domain.model.CoinItem
import io.github.ytam.jetcoinlist.domain.repository.CoinListRepository
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetCoinListUseCase @Inject constructor(
    private val repository: CoinListRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinItem>>> = flow {
        try {
            emit(Resource.Loading<List<CoinItem>>())
            val coins = repository.getCoinList().map { it.toCoinItem() }
            emit(Resource.Success<List<CoinItem>>(coins))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<CoinItem>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<CoinItem>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
