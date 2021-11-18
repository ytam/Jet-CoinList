package io.github.ytam.coinlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ytam.coinlist.common.Constants
import io.github.ytam.coinlist.data.remote.CoinListApi
import io.github.ytam.coinlist.data.repository.CoinListRepositoryImpl
import io.github.ytam.coinlist.domain.repository.CoinListRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinListApi(): CoinListApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinListRepository(api: CoinListApi): CoinListRepository {
        return CoinListRepositoryImpl(api)
    }
}
