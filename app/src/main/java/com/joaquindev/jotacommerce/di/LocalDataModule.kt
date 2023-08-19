package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.dataSource.local.*
import com.joaquindev.jotacommerce.data.dataSource.local.dao.AddressDao
import com.joaquindev.jotacommerce.data.dataSource.local.datastore.AuthDataStore

import com.joaquindev.jotacommerce.data.dataSource.local.dao.CategoriesDao
import com.joaquindev.jotacommerce.data.dataSource.local.dao.ProductsDao
import com.joaquindev.jotacommerce.data.dataSource.local.dao.ShoppingBagDao


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
    @Provides
    fun providesProductsLocalDataSource(productsDao: ProductsDao): ProductsLocalDataSource =
        ProductsLocalDataSourceImpl(productsDao)
    @Provides
    fun providesShoppingBagLocalDataSource(shoppingBagDao: ShoppingBagDao): ShoppingBagLocalDataSource =
        ShoppingBagLocalDataSourceImpl(shoppingBagDao)
 @Provides
    fun providesAddressLocalDataSource(addressDao: AddressDao): AddressLocalDataSource =
        AddressLocalDataSourceImpl(addressDao)
}