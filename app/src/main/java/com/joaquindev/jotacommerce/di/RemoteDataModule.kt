package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.repository.dataSource.AuthRemoteDataSource
import com.joaquindev.jotacommerce.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.joaquindev.jotacommerce.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSources(authService: AuthService): AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(authService)

}