package com.joaquindev.jotacommerce.domain.repository

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Address
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    suspend fun create(address: Address):Resource<Address>
    fun findByUser(idUser:String):Flow<Resource<List<Address>>>

}