package com.joaquindev.jotacommerce.domain.useCase.auth

import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.repository.AuthRepository

class UpdateSessionUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User)= repository.updateSession(user)
}