package io.github.ytam.coinlist.domain.usecase

import io.github.ytam.coinlist.common.Resource
import io.github.ytam.coinlist.data.remote.response.toCoinDetails
import io.github.ytam.coinlist.domain.model.CoinDetails
import io.github.ytam.coinlist.domain.repository.CoinListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinListRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())
            val coin = repository.getCoinDetailsById(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetails>(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDetails>("Couldn't reach server. Check your internet connection."))
        }
    }
}