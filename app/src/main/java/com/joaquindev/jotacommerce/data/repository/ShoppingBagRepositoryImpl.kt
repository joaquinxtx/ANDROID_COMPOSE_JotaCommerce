package com.joaquindev.jotacommerce.data.repository

import android.util.Log
import com.joaquindev.jotacommerce.data.dataSource.local.ShoppingBagLocalDataSource
import com.joaquindev.jotacommerce.data.mapper.toEntity
import com.joaquindev.jotacommerce.data.mapper.toShoppingBagProduct

import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import com.joaquindev.jotacommerce.domain.repository.ShoppingBagRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class ShoppingBagRepositoryImpl(private val localDataSource: ShoppingBagLocalDataSource) :
    ShoppingBagRepository {
    override suspend fun add(product: ShoppingBagProduct) {
        CoroutineScope(Dispatchers.IO).launch {

            val shoppingBag = localDataSource.findById(product.id)
            if (shoppingBag == null) {
                Log.d("ShoppigImplrmrnt", "creando:")
                localDataSource.insert(product.toEntity())
            } else {
                Log.d("ShoppigImplrmrnt", "actualiza:")
                localDataSource.update(product.id, product.quantity)
            }
        }
        }



    override suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    override fun findAll(): Flow<List<ShoppingBagProduct>> = flow {
        localDataSource.findAll().collect() {
            emit(it.map { entity -> entity.toShoppingBagProduct() })
        }
    }

    override suspend fun findById(id: String): ShoppingBagProduct? {
        TODO("Not yet implemented")
    }
}





