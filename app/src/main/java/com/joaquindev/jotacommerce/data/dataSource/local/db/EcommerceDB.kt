package com.joaquindev.jotacommerce.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joaquindev.jotacommerce.data.dataSource.local.dao.AddressDao
import com.joaquindev.jotacommerce.data.dataSource.local.dao.CategoriesDao
import com.joaquindev.jotacommerce.data.dataSource.local.dao.ProductsDao
import com.joaquindev.jotacommerce.data.dataSource.local.dao.ShoppingBagDao
import com.joaquindev.jotacommerce.data.dataSource.local.entity.AddressEntity
import com.joaquindev.jotacommerce.data.dataSource.local.entity.CategoryEntity
import com.joaquindev.jotacommerce.data.dataSource.local.entity.ProductsEntity
import com.joaquindev.jotacommerce.data.dataSource.local.entity.ShoppingBagProductEntity

@Database(
    entities = [CategoryEntity::class , ProductsEntity::class , ShoppingBagProductEntity::class , AddressEntity::class],
    version = 3,
    exportSchema = false
)
abstract class EcommerceDB : RoomDatabase() {

    abstract fun categoryDao():CategoriesDao
    abstract fun ProductsDao():ProductsDao
    abstract fun ShoppingBagDao():ShoppingBagDao
    abstract fun AddressDao():AddressDao

}