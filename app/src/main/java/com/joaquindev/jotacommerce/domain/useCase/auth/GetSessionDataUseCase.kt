package com.joaquindev.jotacommerce.domain.useCase.auth

import com.joaquindev.jotacommerce.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {

    operator fun invoke()= repository.getSessionData()
}