package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.dataSource.remote.*
import com.joaquindev.jotacommerce.data.dataSource.remote.service.AuthService
import com.joaquindev.jotacommerce.data.dataSource.remote.service.CategoryService
import com.joaquindev.jotacommerce.data.dataSource.remote.service.ProductService
import com.joaquindev.jotacommerce.data.dataSource.remote.service.UsersService
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
    @Provides
    fun provideProductRemoteDataSource(productService: ProductService): ProductRemoteDataSource =
        ProductRemoteDataSourceImpl(productService)

}