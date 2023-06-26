package com.joaquindev.jotacommerce.data.repository.dataSource

import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User
import kotlinx.coroutines.flow.Flow

interface  AuthLocalDataSource{

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData():Flow<AuthResponse>
}