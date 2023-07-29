package com.joaquindev.jotacommerce.di

import android.app.Application
import androidx.room.Room
import com.joaquindev.jotacommerce.data.dataSource.local.dao.CategoriesDao
import com.joaquindev.jotacommerce.data.dataSource.local.dao.ProductsDao
import com.joaquindev.jotacommerce.data.dataSource.local.dao.ShoppingBagDao
import com.joaquindev.jotacommerce.data.dataSource.local.db.EcommerceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): EcommerceDB =
        Room.databaseBuilder(app, EcommerceDB::class.java, "ecommerce_db")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesCategoriesDao(db:EcommerceDB):CategoriesDao = db.categoryDao()

    @Provides
    @Singleton
    fun providesProductsDao(db:EcommerceDB):ProductsDao = db.ProductsDao()

    @Provides
    @Singleton
    fun providesShoppingBagDao(db:EcommerceDB):ShoppingBagDao = db.ShoppingBagDao()
}