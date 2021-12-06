package io.github.ytam.jetcoinlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ytam.jetcoinlist.data.remote.common.Constants
import io.github.ytam.jetcoinlist.data.remote.service.CoinListApi
import io.github.ytam.jetcoinlist.data.repository.CoinListRepositoryImpl
import io.github.ytam.jetcoinlist.domain.repository.CoinListRepository
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
