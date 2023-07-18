package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.repository.AuthRepositoryImpl
import com.joaquindev.jotacommerce.data.repository.CategoriesRepositoryImpl
import com.joaquindev.jotacommerce.data.repository.UsersRepositoryImpl
import com.joaquindev.jotacommerce.data.dataSource.local.AuthLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.local.CategoriesLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.AuthRemoteDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.CategoriesRemoteDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.ProductRemoteDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.UsersRemoteDataSource
import com.joaquindev.jotacommerce.data.repository.ProductRepositoryImpl
import com.joaquindev.jotacommerce.domain.repository.AuthRepository
import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository
import com.joaquindev.jotacommerce.domain.repository.ProductRepository
import com.joaquindev.jotacommerce.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,

        ): UserRepository = UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideCategoriesRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
        categoriesLocalDataSource: CategoriesLocalDataSource

    ): CategoriesRepository =
        CategoriesRepositoryImpl(categoriesRemoteDataSource, categoriesLocalDataSource)

    @Provides
    fun provideProductRepository(
        productRemoteDataSource: ProductRemoteDataSource

    ): ProductRepository = ProductRepositoryImpl(productRemoteDataSource)

}