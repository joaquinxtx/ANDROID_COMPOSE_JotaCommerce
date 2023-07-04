package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.repository.dataSource.AuthRemoteDataSource
import com.joaquindev.jotacommerce.data.repository.dataSource.CategoriesRemoteDataSource
import com.joaquindev.jotacommerce.data.repository.dataSource.UsersRemoteDataSource
import com.joaquindev.jotacommerce.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.joaquindev.jotacommerce.data.repository.dataSourceImpl.CategoriesRemoteDataSourceImpl
import com.joaquindev.jotacommerce.data.repository.dataSourceImpl.UsersRemoteDataSourceImpl
import com.joaquindev.jotacommerce.data.service.AuthService
import com.joaquindev.jotacommerce.data.service.CategoryService
import com.joaquindev.jotacommerce.data.service.UsersService
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

    @Provides
    fun provideUsersRemoteDataSources(usersService: UsersService): UsersRemoteDataSource =
        UsersRemoteDataSourceImpl(usersService)

    @Provides
    fun provideCategoriesRemoteDataSource(categoryService: CategoryService): CategoriesRemoteDataSource =
        CategoriesRemoteDataSourceImpl(categoryService)

}