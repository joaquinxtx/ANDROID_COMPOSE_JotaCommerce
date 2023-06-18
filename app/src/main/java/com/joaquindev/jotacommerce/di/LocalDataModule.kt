package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.datastore.AuthDataStore
import com.joaquindev.jotacommerce.data.repository.dataSource.AuthLocalDataSource

import com.joaquindev.jotacommerce.data.repository.dataSourceImpl.AuthLocalDataSourceImpl


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSources(authDataStore: AuthDataStore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDataStore)

}