package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.dataSource.local.AuthLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.local.CategoriesLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.local.ProductsLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.local.ShoppingBagLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.AuthRemoteDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.CategoriesRemoteDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.ProductRemoteDataSource
import com.joaquindev.jotacommerce.data.dataSource.remote.UsersRemoteDataSource
import com.joaquindev.jotacommerce.data.repository.*
import com.joaquindev.jotacommerce.domain.repository.*
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
        productRemoteDataSource: ProductRemoteDataSource,
        productsLocalDataSource: ProductsLocalDataSource

    ): ProductRepository = ProductRepositoryImpl(productRemoteDataSource,productsLocalDataSource)

    @Provides
    fun provideShoppingBagRepository(
     shoppingBagLocalDataSource: ShoppingBagLocalDataSource
    ): ShoppingBagRepository = ShoppingBagRepositoryImpl(shoppingBagLocalDataSource)

}