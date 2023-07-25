package com.joaquindev.jotacommerce.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joaquindev.jotacommerce.data.dataSource.local.dao.CategoriesDao
import com.joaquindev.jotacommerce.data.dataSource.local.dao.ProductsDao
import com.joaquindev.jotacommerce.data.dataSource.local.entity.CategoryEntity
import com.joaquindev.jotacommerce.data.dataSource.local.entity.ProductsEntity

@Database(
    entities = [CategoryEntity::class , ProductsEntity::class],
    version = 2,
    exportSchema = false
)
abstract class EcommerceDB : RoomDatabase() {

    abstract fun categoryDao():CategoriesDao
    abstract fun ProductsDao():ProductsDao


}