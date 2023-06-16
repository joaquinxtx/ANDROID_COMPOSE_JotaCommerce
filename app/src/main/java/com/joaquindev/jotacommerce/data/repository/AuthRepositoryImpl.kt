package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.repository.dataSource.AuthRemoteDataSource
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.repository.AuthRepository

class AuthRepositoryImpl (private val authRemoteDataSource: AuthRemoteDataSource ):AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            Resource.Success(result.body()!!)
        }catch (e:Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }


}