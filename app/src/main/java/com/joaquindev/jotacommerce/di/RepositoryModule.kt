package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.dataSource.local.*
import com.joaquindev.jotacommerce.data.dataSource.remote.*
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

    @Provides
    fun provideAddressRepository(
     addressRemoteDataSource: AddressRemoteDataSource,
     addressLocalDataSource: AddressLocalDataSource,
    ): AddressRepository = AddressRepositoryImpl(addressRemoteDataSource , addressLocalDataSource)
@Provides
    fun provideMercadoPagoRepository(
     mercadoPagoRemoteDataSource: MercadoPagoRemoteDataSource,

    ): MercadoPagoRepository = MercadoPagoRepositoryImpl(mercadoPagoRemoteDataSource)

}