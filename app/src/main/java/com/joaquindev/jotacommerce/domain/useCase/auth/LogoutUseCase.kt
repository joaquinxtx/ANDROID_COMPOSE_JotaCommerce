package com.joaquindev.jotacommerce.domain.useCase.auth

import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.repository.AuthRepository

class LogoutUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke()= repository.logout()
}