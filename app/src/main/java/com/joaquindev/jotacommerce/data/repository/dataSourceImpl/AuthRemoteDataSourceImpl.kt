package com.joaquindev.jotacommerce.data.repository.dataSourceImpl

import com.joaquindev.jotacommerce.data.repository.dataSource.AuthRemoteDataSource
import com.joaquindev.jotacommerce.data.service.AuthService
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User

import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource {
    override suspend fun login(email: String, password: String): Response<AuthResponse> =
        authService.login(email, password)

    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)

}