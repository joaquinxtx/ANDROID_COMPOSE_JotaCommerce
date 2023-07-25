package com.joaquindev.jotacommerce.data.dataSource.local

import com.joaquindev.jotacommerce.data.dataSource.local.dao.ProductsDao
import com.joaquindev.jotacommerce.data.dataSource.local.entity.CategoryEntity
import com.joaquindev.jotacommerce.data.dataSource.local.entity.ProductsEntity
import kotlinx.coroutines.flow.Flow

class ProductsLocalDataSourceImpl(private val productsDao: ProductsDao) : ProductsLocalDataSource {
    override suspend fun insert(product: ProductsEntity) = productsDao.insert(product)

    override suspend fun insertAll(products: List<ProductsEntity>) = productsDao.insertAll(products)

    override fun findAll(): Flow<List<ProductsEntity>> = productsDao.findAll()
    override fun findByCategory(idCategory: String): Flow<List<ProductsEntity>> =
        productsDao.findByCategory(idCategory)

    override suspend fun update(
        id: String,
        name: String,
        description: String,
        image1: String,
        image2: String,
        price: Double
    ) = productsDao.update(id, name, description, image1, image2, price)

    override suspend fun delete(id: String) = productsDao.delete(id)
}