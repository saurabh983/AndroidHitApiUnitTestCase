package com.maintain.utcwh.di

import com.maintain.utcwh.data.APIs
import com.maintain.utcwh.data.repository.ApiRepository
import com.maintain.utcwh.data.repository.ApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class AppRepoModule {
    @Provides
    fun providesApiRepository(apiServices: APIs): ApiRepository =
        ApiRepositoryImpl(apiServices)
}