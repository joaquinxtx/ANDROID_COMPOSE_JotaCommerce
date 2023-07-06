package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.dataSource.local.datastore.AuthDataStore
import com.joaquindev.jotacommerce.data.dataSource.local.AuthLocalDataSource

import com.joaquindev.jotacommerce.data.dataSource.local.AuthLocalDataSourceImpl
import com.joaquindev.jotacommerce.data.dataSource.local.CategoriesLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.local.CategoriesLocalDataSourceImpl
import com.joaquindev.jotacommerce.data.dataSource.local.dao.CategoriesDao


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

    @Provides
    fun providesCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource =
        CategoriesLocalDataSourceImpl(categoriesDao)
}