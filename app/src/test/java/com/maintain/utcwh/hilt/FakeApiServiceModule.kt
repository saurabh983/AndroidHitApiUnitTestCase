package com.maintain.utcwh.hilt

import com.maintain.utcwh.api.FakeApiService
import com.maintain.utcwh.data.APIs
import com.maintain.utcwh.di.NetworkModule
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [NetworkModule::class])
abstract class FakeApiServiceModule {

    @Binds
    @Singleton
    abstract fun providesApi(fakeApiService: FakeApiService): APIs
}